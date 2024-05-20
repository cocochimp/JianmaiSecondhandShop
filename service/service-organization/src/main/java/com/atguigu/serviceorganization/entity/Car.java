package com.atguigu.serviceorganization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class Car {

    @ApiModelProperty(value = "购物车id")
    @TableId(value = "car_id", type = IdType.ID_WORKER_STR)
    private String carId;

    @ApiModelProperty(value = "购物车的用户id")
    @TableId(value = "car_userid", type = IdType.ID_WORKER_STR)
    private String carUserId;

    @ApiModelProperty(value = "购物车的商品id")
    @TableId(value = "car_shopid", type = IdType.ID_WORKER_STR)
    private String carShopId;

    public Car(String carId, String carUserId, String carShopId) {
        this.carId = carId;
        this.carUserId = carUserId;
        this.carShopId = carShopId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarUserId() {
        return carUserId;
    }

    public void setCarUserId(String carUserId) {
        this.carUserId = carUserId;
    }

    public String getCarShopId() {
        return carShopId;
    }

    public void setCarShopId(String carShopId) {
        this.carShopId = carShopId;
    }
}
