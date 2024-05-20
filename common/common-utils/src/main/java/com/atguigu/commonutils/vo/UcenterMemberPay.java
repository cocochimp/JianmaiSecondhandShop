package com.atguigu.commonutils.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UcenterMemberPay {

    @ApiModelProperty(value = "会员id")
    private String id;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

}
