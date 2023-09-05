package com.atguigu.serviceorganization.controller;

import com.atguigu.serviceorganization.entity.*;
import com.atguigu.serviceorganization.exception.AllException;
import com.atguigu.serviceorganization.mapper.ShoppingCartMapper;
import com.atguigu.serviceorganization.util.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

//解决跨域问题@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin
@RestController
@RequestMapping("/Car")
@Api(tags = "4、购物车管理接口")
public class ShoppingCartController {

    ResultVo<Object> resultVo = new ResultVo<>();

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    //4.1 展示购物车的商品
    @ApiOperation(value = "4.1 展示购物车的商品【通过carUserId】")
    @PostMapping("/query/carList/{carUserId}")
    public ResultVo<Object> queryCarList(@PathVariable("carUserId") String carUserId)
    {
        try{
            List<Map<String, String>> info = shoppingCartMapper.queryCarList(carUserId);

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

    //4.2 购买购物车的商品
    @ApiOperation(value = "4.2 购买购物车的商品【通过订单的商品id——>orderGoodsId】")
    @PostMapping("/update/carGoods")
    public ResultVo<Object> updateCarGoods(Order order)
    {
        try{
            //生成订单号orderId
            SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
            long Id = idWorker.nextId();
            String orderId=String.valueOf(Id);

            //生成订单时间orderData
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            //生成商品订单对应的卖家信息orderSaleUserId
            String orderSaleUserId=shoppingCartMapper.queryGoodsUserId(order.getOrderGoodsId());
            int OrderPrice = shoppingCartMapper.queryGoodsPrice(order.getOrderGoodsId());

            //生成商品对应的买家id(通过购物车car)
            String carUserId = shoppingCartMapper.queryCarUser(order.getOrderGoodsId());

            Car car1 = new Car("0",carUserId,"0");
            Order order1 = new Order(orderId,carUserId,orderSaleUserId,order.getOrderGoodsId(),OrderPrice,"未发货",dateTime.format(formatter));

            shoppingCartMapper.insertOrderInfo(order1);
            shoppingCartMapper.updateCarGoods(car1);

            resultVo.setData("购买购物车的商品成功！");
            resultVo.setMess("ok");
            resultVo.setOk(true);
        }catch (AllException e){
            resultVo.setMess(e.getMessage());
            resultVo.setOk(false);
        }


        return resultVo;
    }

    //4.3 删除购物车的商品
    @ApiOperation(value = "4.3 删除购物车的商品【通过carShopId和carUserId】")
    @PostMapping("/delete/carGoods/{carShopId}/{carUserId}")
    public ResultVo<Object> deleteCarGoods(@PathVariable("carShopId") String carShopId,@PathVariable("carUserId") String carUserId)
    {
        try{
            shoppingCartMapper.deleteCarGoods(carShopId);

            resultVo.setData(shoppingCartMapper.queryCarList(carUserId));
            resultVo.setMess("ok");
            resultVo.setOk(true);
        }catch (AllException e){
            resultVo.setMess(e.getMessage());
            resultVo.setOk(false);
        }

        return resultVo;
    }

    //4.4 添加一个商品到购物车
    @ApiOperation(value = "4.4 添加一个商品到购物车【不用填carId】")
    @PostMapping("/insert/carGoods")
    public ResultVo<Object> insertCarInfo(Car car)
    {
        try{
            if(shoppingCartMapper.queryCarInfo(car)==0){
                //通过商品买家找到对应的购物车id（当前人员）
                String carId = shoppingCartMapper.queryUserCarId(car.getCarUserId());

                Car car1 = new Car(carId,car.getCarUserId(),car.getCarShopId());
                shoppingCartMapper.insertCarInfo(car1);

                resultVo.setData("添加成功!");
                resultVo.setMess("ok");
                resultVo.setOk(true);
            }else{
                resultVo.setData("添加失败，购物车内已有本商品！");
                resultVo.setMess("false");
                resultVo.setOk(false);
            }
        }catch (AllException e){
            resultVo.setMess(e.getMessage());
            resultVo.setOk(false);
        }
        return resultVo;
    }

}

