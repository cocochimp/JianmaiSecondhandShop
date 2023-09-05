package com.atguigu.serviceorganization.mapper;

import com.atguigu.serviceorganization.entity.Car;
import com.atguigu.serviceorganization.entity.Goods;
import com.atguigu.serviceorganization.entity.Order;
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
public interface ShoppingCartMapper extends BaseMapper<User> {

    //4.1 展示购物车的商品
    @Select("select u.nickname,c.car_userid,g.* " +
            "from car c,goods g,`user` u " +
            "where c.car_shopid=g.goods_id and u.user_id=g.goods_user_id and c.car_userid=#{carUserId} ")
    List<Map<String,String>> queryCarList(@Param("carUserId") String carUserId);

    //4.2 购买购物车的商品
    //4.2.1 修改购物车状态
    //购物车的商品id对应设为0
    @Update("update car " +
            "set car_shopid=#{carShopId} " +
            "where car_userid=#{carUserId};")
    void updateCarGoods(Car car);

    //找到该商品的卖方
    @Select("select goods_user_id " +
            "from goods " +
            "where goods_id=#{goodsId}")
    String queryGoodsUserId(@Param("goodsId") String goodsId);

    //找到该商品的价格
    @Select("select goods_price " +
            "from goods " +
            "where goods_id=#{goodsId}")
    int queryGoodsPrice(@Param("goodsId") String goodsId);

    //找到商品对应的买家（当前人员）
    @Select("select c.car_userid " +
            "from `goods` g,car c " +
            "where g.goods_id=c.car_shopid and g.goods_id=#{goodsId}")
    String queryCarUser(@Param("goodsId") String goodsId);

    //4.2.2 增加一条新的订单
    @Insert("insert into `order` " +
            "values(#{orderId},#{orderBuyUserId},#{orderSaleUserId},#{orderGoodsId},#{orderPrice},#{orderStatus},#{orderData})")
    void insertOrderInfo(Order order);

    //4.3 删除购物车的商品
    @Update("update car " +
            "set car_shopid='0' " +
            "where car_shopid=#{carShopId}; ")
    void deleteCarGoods(@Param("carShopId") String carShopId);

    //4.4 添加一个商品到购物车
    //先查询该用户的购物车里是否有该商品
    @Select("select count(*) " +
            "from car " +
            "where car_userid=#{carUserId} and car_shopid=#{carShopId}")
    int queryCarInfo(Car car);

    //通过商品买家找到对应的购物车id（当前人员）
    @Select("select distinct car_id " +
            "from car " +
            "where car_userid=#{carUserId} ")
    String queryUserCarId(@Param("carUserId") String carUserId);

    //插入一条购物车的信息
    @Insert("insert into car " +
            "values (#{carId},#{carUserId},#{carShopId})")
    void insertCarInfo(Car car);

}
