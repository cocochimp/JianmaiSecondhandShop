package com.atguigu.serviceorganization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class Order {

    @ApiModelProperty(value = "订单id")
    @TableId(value = "order_id", type = IdType.ID_WORKER_STR)
    private String orderId;

    @ApiModelProperty(value = "订单的买家用户id")
    @TableId(value = "order_buy_user_id", type = IdType.ID_WORKER_STR)
    private String orderBuyUserId;

    @ApiModelProperty(value = "订单的卖家用户id")
    @TableId(value = "order_sale_user_id", type = IdType.ID_WORKER_STR)
    private String orderSaleUserId;

    @ApiModelProperty(value = "订单的商品id")
    @TableId(value = "order_goods_id", type = IdType.ID_WORKER_STR)
    private String orderGoodsId;

    @ApiModelProperty(value = "订单价格")
    @TableField(value = "order_price")
    private int orderPrice;

    @ApiModelProperty(value = "订单状态")
    @TableField(value = "order_status")
    private String orderStatus;

    @ApiModelProperty(value = "订单日期")
    @TableField(value = "order_data")
    private String orderData;

    public Order(String orderId, String orderBuyUserId, String orderSaleUserId, String orderGoodsId, int orderPrice, String orderStatus, String orderData) {
        this.orderId = orderId;
        this.orderBuyUserId = orderBuyUserId;
        this.orderSaleUserId = orderSaleUserId;
        this.orderGoodsId = orderGoodsId;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
        this.orderData = orderData;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderBuyUserId() {
        return orderBuyUserId;
    }

    public void setOrderBuyUserId(String orderBuyUserId) {
        this.orderBuyUserId = orderBuyUserId;
    }

    public String getOrderSaleUserId() {
        return orderSaleUserId;
    }

    public void setOrderSaleUserId(String orderSaleUserId) {
        this.orderSaleUserId = orderSaleUserId;
    }

    public String getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(String orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }
}
