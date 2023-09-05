package com.atguigu.serviceorganization.controller;

import com.atguigu.serviceorganization.entity.*;
import com.atguigu.serviceorganization.exception.AllException;
import com.atguigu.serviceorganization.mapper.UserMapper;
import com.atguigu.serviceorganization.util.SnowflakeIdWorker;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//解决跨域问题@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin
@RestController
@RequestMapping("/User")
@Api(tags = "1、用户管理接口")
public class UserController {

    ResultVo<Object> resultVo = new ResultVo<>();

    @Autowired
    UserMapper userMapper;

    //1.1 用户注册
    @ApiOperation(value = "1.1 用户注册【填3/4/5】")
    @PostMapping("/insert/user")
    public ResultVo<Object> InsertUser(User user)
    {
        try{
            Integer num = userMapper.queryUserNum(user.getNickName());

            if(num==0 && !user.getNickName().equals("") && !user.getUserImage().equals("") && !user.getUserPwd().equals("")){
                //为用户及其购物车生成专属的雪花id
                SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
                long id01 = idWorker.nextId();
                long id02 = idWorker.nextId();
                User user01 = new User(id01,id02,user.getUserImage(),user.getUserPwd(),user.getNickName());
                Car car01 = new Car(String.valueOf(id02),String.valueOf(id01),"0");

                userMapper.insertUser(user01);
                userMapper.insertCar(car01);

                resultVo.setMess("注册成功");
                resultVo.setOk(true);
            }else{
                resultVo.setMess("用户名已被注册");
                resultVo.setOk(false);
            }

        }catch (AllException e){
            resultVo.setMess("姓名、密码和头像不能为空！");
            resultVo.setOk(false);
        }
        return resultVo;
    }


    //1.2 用户登录&后台信息显示
    @ApiOperation(value = "1.2 用户登录&后台信息显示")
    @PostMapping("/login/{nickName}/{userPwd}")
    public ResultVo<Object> queryParty(@PathVariable("nickName") String userName,
                                       @PathVariable("userPwd") String userPwd)
    {
        try{
            List<Map<String, String>> info = userMapper.queryLogin(userName,userPwd);

            //data=info.get(0).get("user_id");
            if (info.isEmpty()){
                resultVo.setData(null);
                resultVo.setMess("账号或密码错误！");
                resultVo.setOk(false);
            }else{
                resultVo.setData(info);
                resultVo.setMess("登录成功！");
                resultVo.setOk(true);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("登录失败");
            resultVo.setOk(false);
        }
        return resultVo;
    }


    //1.3 修改个人信息
    @ApiOperation(value = "1.3 修改个人信息【不用填userCarId】")
    @PostMapping("/update/userInfo")
    public ResultVo<Object> UpdateUserInfo(User user)
    {
        try{
            userMapper.updateUserInfo(user);
            resultVo.setMess("修改个人信息成功！");
            resultVo.setOk(true);
        }catch (AllException e){
            resultVo.setMess("修改人物信息失败！");
            resultVo.setOk(false);
        }
        return resultVo;
    }

}

