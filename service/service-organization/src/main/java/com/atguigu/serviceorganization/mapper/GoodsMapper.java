package com.atguigu.serviceorganization.mapper;

import com.atguigu.serviceorganization.entity.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
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
public interface GoodsMapper extends BaseMapper<User> {

    //2.1 二手市场首页商品信息的浏览
    @Select("select u.nickname,g.* " +
            "from goods g,`user` u " +
            "where g.goods_user_id=u.user_id and g.goods_id not in( " +
            "select order_goods_id " +
            "from `order`)")
    List<Map<String,String>> queryGoodsList();

    //2.2 本系统中所有商品的多种查询功能
    //2.2.1 商品价格区间
    @Select("select u.nickname,g.* " +
            "from goods g,`user` u " +
            "where g.goods_user_id=u.user_id and g.goods_id not in( " +
            "select order_goods_id " +
            "from `order`) and g.goods_price>=#{min} and g.goods_price<=#{max}")
    List<Map<String,String>> queryGoodsPrice(@Param("min") String min,@Param("max") String max);

    //2.2.2 商品名称（模糊查询）
    @Select("select u.nickname,g.* " +
            "from goods g,`user` u " +
            "where g.goods_user_id=u.user_id and g.goods_id not in( " +
            "select order_goods_id " +
            "from `order`) and goods_name like concat('%',#{GoodsName},'%')")
    List<Map<String,String>> queryGoodsName(@Param("GoodsName") String GoodsName);

    //2.2.3 商品发布者姓名（模糊查询）
    @Select("select u.nickname,g.* " +
            "from goods g,`user` u " +
            "where g.goods_user_id=u.user_id and g.goods_id not in( " +
            "select order_goods_id " +
            "from `order`) and nickname like concat('%',#{UserName},'%')")
    List<Map<String,String>> queryUserName(@Param("UserName") String UserName);

    //2.2.4.1 商品类型（全部展示）
    @Select("select distinct goods_category " +
            "from goods;")
    List<Map<String,String>> queryGoodsTitle();

    //2.2.4.2 商品类型（直接查询）
    @Select("select u.nickname,g.* " +
            "from goods g,`user` u " +
            "where g.goods_user_id=u.user_id and g.goods_id not in( " +
            "select order_goods_id " +
            "from `order`) and goods_category=#{GoodsCategory}")
    List<Map<String,String>> queryGoodsCategory(@Param("GoodsCategory") String GoodsCategory);

    //3.1 商品管理中的商品列表显示
    @Select("select g.* " +
            "from goods g " +
            "where g.goods_user_id=#{goodsUserId} and g.goods_id not in( " +
            "select g.goods_id " +
            "from goods g,`order` o " +
            "where g.goods_id=o.order_goods_id and g.goods_user_id=#{goodsUserId} " +
            ")")
    List<Map<String,String>> queryGoodsListByUser(@Param("goodsUserId") String goodsUserId);


    //3.2 二手市场商品的发布【goods_user_id需要前端自己获得】
    @Insert("insert into goods " +
            "values (#{goodsId},#{goodsUserId},#{goodsName},#{goodsPrice},#{goodsCategory},#{goodsImage});")
    void insertGoods(Goods goods);

    @Select("select * " +
            "from goods " +
            "where goods_id=#{GoodsId}")
    List<Map<String,String>> queryGoodsInfo(@Param("GoodsId") Long GoodsId);

    //3.3 对已发布商品状态和信息的修改
    @Update("update goods g " +
            "set g.goods_name=#{goodsName}, " +
            "g.goods_price=#{goodsPrice}, " +
            "g.goods_category=#{goodsCategory}, " +
            "g.goods_image=#{goodsImage} " +
            "where g.goods_id=#{goodsId}")
    void updateGoods(Goods goods);

    //3.4 对已发布商品状态和信息的删除
    @Delete("delete from goods " +
            "where goods_id=#{GoodId}")
    void deleteGoods(@Param("GoodId") String GoodId);


}
