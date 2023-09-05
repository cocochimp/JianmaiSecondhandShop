package com.atguigu.serviceorganization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


public class Goods {

    @ApiModelProperty(value = "商品id")
    @TableId(value = "goods_id", type = IdType.ID_WORKER_STR)
    private Long goodsId;

    @ApiModelProperty(value = "商品所属人id")
    @TableField(value = "goods_user_id")
    private String goodsUserId;

    @ApiModelProperty(value = "商品名称")
    @TableField(value = "goods_name")
    private String goodsName;

    @ApiModelProperty(value = "价格")
    @TableField(value = "goods_price")
    private int goodsPrice;

    @ApiModelProperty(value = "类型")
    @TableField(value = "goods_category")
    private String goodsCategory;

    @ApiModelProperty(value = "商品图像地址")
    @TableField(value = "goods_image")
    private String goodsImage;

    public Goods(Long goodsId, String goodsUserId, String goodsName, int goodsPrice, String goodsCategory, String goodsImage) {
        this.goodsId = goodsId;
        this.goodsUserId = goodsUserId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsCategory = goodsCategory;
        this.goodsImage = goodsImage;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsUserId() {
        return goodsUserId;
    }

    public void setGoodsUserId(String goodsUserId) {
        this.goodsUserId = goodsUserId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }
}
