package com.atguigu.serviceorganization.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

public class User {

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    private Long userId;

    @ApiModelProperty(value = "用户的购物车id")
    @TableId(value = "user_car_id", type = IdType.ID_WORKER_STR)
    private Long userCarId;

    @ApiModelProperty(value = "用户头像地址")
    @TableField(value = "user_image")
    private String userImage;

    @ApiModelProperty(value = "用户密码")
    @TableField(value = "user_pwd")
    private String userPwd;

    @ApiModelProperty(value = "用户昵称")
    @TableField(value = "nickname")
    private String nickName;

    public User(Long userId, Long userCarId, String userImage, String userPwd, String nickName) {
        this.userId = userId;
        this.userCarId = userCarId;
        this.userImage = userImage;
        this.userPwd = userPwd;
        this.nickName = nickName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Long userCarId) {
        this.userCarId = userCarId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
