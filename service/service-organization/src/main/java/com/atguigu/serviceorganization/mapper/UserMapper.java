package com.atguigu.serviceorganization.mapper;

import com.atguigu.serviceorganization.entity.Car;
import com.atguigu.serviceorganization.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Service
public interface UserMapper extends BaseMapper<User> {

    //1.1 用户注册
    @Select("select count(*) " +
            "from `user` " +
            "where nickname=#{nickName};")
    Integer queryUserNum(@Param("nickName") String nickName);

    @Insert("insert into `user` " +
            "values (#{userId},#{userCarId},#{userImage},#{userPwd},#{nickName});")
    void insertUser(User user);

    @Insert("insert into car " +
            "values (#{carId},#{carUserId},#{carShopId});")
    void insertCar(Car car);

    //1.2 用户登录
    @Select("select * " +
            "from `user` as u " +
            "where u.nickname=#{nickName} and u.user_pwd=#{userPwd}")
    List<Map<String,String>> queryLogin(@Param("nickName") String nickName,@Param("userPwd") String userPwd);

    //1.3 个人信息的修改
    @Update("update `user` " +
            "set user_image=#{userImage}, " +
            "user_pwd=#{userPwd}, " +
            "nickname=#{nickName} " +
            "where user_id=#{userId}")
    void updateUserInfo(User user);

}
