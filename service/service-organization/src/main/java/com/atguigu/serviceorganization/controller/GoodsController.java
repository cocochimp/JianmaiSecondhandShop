package com.atguigu.serviceorganization.controller;

import com.atguigu.serviceorganization.entity.*;
import com.atguigu.serviceorganization.exception.AllException;
import com.atguigu.serviceorganization.mapper.GoodsMapper;
import com.atguigu.serviceorganization.service.OssService;
import com.atguigu.serviceorganization.util.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

//解决跨域问题@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin
@RestController
@RequestMapping("/Goods")
@Api(tags = "2/3、商品管理接口")
public class GoodsController {

    ResultVo<Object> resultVo = new ResultVo<>();

    @Autowired
    GoodsMapper goodsMapper;
    @Resource
    OssService ossService;

    //2.1 二手市场首页商品信息的浏览
    @ApiOperation(value = "2.1 二手市场首页商品信息的浏览")
    @PostMapping("/query/goodsList")
    public ResultVo<Object> queryGoodsList()
    {
        try{
            List<Map<String, String>> info = goodsMapper.queryGoodsList();

            resultVo.setData(info);
            resultVo.setMess("true");
            resultVo.setOk(true);

        }
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("false");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    //2.2 本系统中所有商品的多种查询功能
    //2.2.1 商品价格区间
    @ApiOperation(value = "2.2-1 商品价格区间")
    @PostMapping("/query/goodsPrice/{min}/{max}")
    public ResultVo<Object> queryGoodsPrice(@PathVariable("min") String min,@PathVariable("max") String max)
    {
        try{
            List<Map<String, String>> info = goodsMapper.queryGoodsPrice(min,max);

            resultVo.setData(info);
            resultVo.setMess("true");
            resultVo.setOk(true);

        }
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("false");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    //2.2.2 商品名称（模糊查询）
    @ApiOperation(value = "2.2-2 商品名称（模糊查询）")
    @PostMapping("/query/goodsName/{GoodsName}")
    public ResultVo<Object> queryGoodsName(@PathVariable("GoodsName") String GoodsName)
    {
        try{
            List<Map<String, String>> info = goodsMapper.queryGoodsName(GoodsName);

            resultVo.setData(info);
            resultVo.setMess("true");
            resultVo.setOk(true);

        }
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("false");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    //2.2.3 商品发布者姓名（模糊查询）
    @ApiOperation(value = "2.2-3 商品发布者姓名（模糊查询）")
    @PostMapping("/query/userName/{UserName}")
    public ResultVo<Object> queryUserName(@PathVariable("UserName") String UserName)
    {
        try{
            List<Map<String, String>> info = goodsMapper.queryUserName(UserName);

            resultVo.setData(info);
            resultVo.setMess("true");
            resultVo.setOk(true);

        }
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("false");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    //2.2.4.1 商品类型（全部展示）
    @ApiOperation(value = "2.2-4 商品类型（全部展示）")
    @PostMapping("/query/goodsTitle")
    public ResultVo<Object> queryGoodsTitle()
    {
        try{
            List<Map<String, String>> info = goodsMapper.queryGoodsTitle();

            resultVo.setData(info);
            resultVo.setMess("success!");
            resultVo.setOk(true);

        }
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("false!");
            resultVo.setOk(false);
        }
        return resultVo;
    }

    //2.2.4.2 商品类型（直接查询）
    @ApiOperation(value = "2.2-4 商品类型（直接查询）")
    @PostMapping("/query/goodsCategory/{GoodsCategory}")
    public ResultVo<Object> queryGoodsCategory(@PathVariable("GoodsCategory") String GoodsCategory)
    {
        try{
            List<Map<String, String>> info = goodsMapper.queryGoodsCategory(GoodsCategory);

            resultVo.setData(info);
            resultVo.setMess("success!");
            resultVo.setOk(true);

        }
        catch (Exception e){
            e.printStackTrace();
            resultVo.setMess("false!");
            resultVo.setOk(false);
        }
        return resultVo;
    }


    //3.1 商品管理中的商品列表显示
    @ApiOperation(value = "3.1 商品管理中的商品列表显示【通过用户id】")
    @PostMapping("/query/goodsList/{goodsUserId}")
    public ResultVo<Object> queryGoodsListByUser(@PathVariable("goodsUserId") String goodsUserId)
    {
        try{
            resultVo.setData(goodsMapper.queryGoodsListByUser(goodsUserId));
            resultVo.setMess("展示该用户的商品管理成功!");
            resultVo.setOk(true);
        }catch (AllException e){
            resultVo.setMess(e.getMessage());
            resultVo.setOk(false);
        }

        return resultVo;
    }

    //3.2 二手市场商品的发布【goods_user_id需要前端自己获得】
    @ApiOperation(value = "3.2 二手市场商品的发布【不用填goodsId】")
    @PostMapping("/insert/goods")
    public ResultVo<Object> insertGoods(Goods goods)
    {
        try{
            if(!goods.getGoodsUserId().equals("")){
                SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
                long id = idWorker.nextId();

                Goods goods1 = new Goods(id,goods.getGoodsUserId(),goods.getGoodsName(),goods.getGoodsPrice(),goods.getGoodsCategory(),goods.getGoodsImage());
                goodsMapper.insertGoods(goods1);

                resultVo.setData(goodsMapper.queryGoodsInfo(id));
                resultVo.setMess("发布二手商品成功!");
                resultVo.setOk(true);
            }else{
                resultVo.setData("发布二手商品失败！");
                resultVo.setMess("false");
                resultVo.setOk(false);
            }

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
        }


        return resultVo;
    }

    //3.3 对已发布商品状态和信息的修改
    @ApiOperation(value = "3.3 对已发布商品状态和信息的修改【不用填goodsUserId】")
    @PostMapping("/update/goods")
    public ResultVo<Object> updateGoods(Goods goods)
    {
        try{
            Goods goods1 = new Goods(goods.getGoodsId(),goods.getGoodsUserId(),goods.getGoodsName(),goods.getGoodsPrice(),goods.getGoodsCategory(),goods.getGoodsImage());
            goodsMapper.updateGoods(goods1);

            resultVo.setData(goodsMapper.queryGoodsInfo(goods.getGoodsId()));
            resultVo.setMess("修改二手商品成功！");
            resultVo.setOk(true);

        }catch (AllException e){
            resultVo.setMess(e.getMessage());
            resultVo.setOk(false);
        }

        return resultVo;
    }

    //3.4 对已发布商品状态和信息的删除
    @ApiOperation(value = "3.4 对已发布商品状态和信息的删除")
    @PostMapping("/delete/goods/{GoodId}")
    public ResultVo<Object> deleteGoods(@PathVariable("GoodId") String GoodId)
    {
        try{
            goodsMapper.deleteGoods(GoodId);

            resultVo.setData("删除二手商品成功！");
            resultVo.setMess("ok");
            resultVo.setOk(true);
        }catch (AllException e){
            resultVo.setMess(e.getMessage());
            resultVo.setOk(false);
        }

        return resultVo;
    }

    /**
     * 上传图片接口
     * */
    @PostMapping("/uploadAvator")
    public ResultVo<Object> uploadOssFile(@RequestParam("file") MultipartFile file) {
        System.out.println("file::"+file);
        String url = ossService.uploadFileAvatar(file);
        System.out.println("url::"+url);
        return new ResultVo<>("上传到oss成功！",true,url);
    }

}

