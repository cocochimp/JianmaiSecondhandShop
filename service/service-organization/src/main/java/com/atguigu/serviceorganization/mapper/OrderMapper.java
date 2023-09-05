package com.atguigu.serviceorganization.mapper;

import com.atguigu.serviceorganization.entity.*;
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
public interface OrderMapper extends BaseMapper<User> {

    //5.1 交易列表展示
    @Select("select g.goods_image,g.goods_name,g.goods_category,u.nickname sale_user_name,o.* " +
            "from `order` o,`user` u,goods g " +
            "where o.order_goods_id=g.goods_id and o.order_sale_user_id=u.user_id and o.order_buy_user_id=#{orderBuyUserId}")
    List<Map<String,String>> queryOrderList(@Param("orderBuyUserId") String orderBuyUserId);

    //5.2 交易状态修改
    @Select("select status_name " +
            "from `status`")
    List<Map<String,String>> queryOrderStatus();

    @Update("update `order` " +
            "set order_status=#{orderStatus} " +
            "where order_id=#{orderId} ")
    void updateOrderStatus(@Param("orderStatus") String orderStatus,@Param("orderId") String orderId);

    //5.3 对卖家做出信用评价（打分）
    //查询该订单是否为“已确认收货”
    @Select("select o.order_status " +
            "from `order` o " +
            "where o.order_id=#{orderId} ")
    String queryIfReceive(@Param("orderId") String orderId);

    //设置订单为“已评价”
    @Update("update `order` " +
            "set order_status='已评价' " +
            "where order_id=#{orderId}")
    void updateOrderFinalStatus(@Param("orderId") String orderId);

}
