package com.atguigu.serviceorganization.exception;

public enum AllEnum {
    LUNBOTU_LIST("001-001","轮播图展示失败"),
    LUNBOTU_UPLOAD("001-002","上传轮播图失败"),
    ARTICLE_ADD("002-001","添加文章失败"),
    ARTICLE_DELETE("002-002","删除文章失败"),
    ARTICLE_UPDATE("002-003","修改文章失败"),
    ARTICLE_QUERYALLARTICLES("002-004","查询所有文章失败"),
    ARTICLE_QUERYARTICLEBYID("002-005","查询指定id文章失败"),
    DANGPAI_QUERYALL("003-001","查询所有党派成员失败"),
    DANGPAI_QUERYBYID("003-002","查询指定id党派成员失败"),
    DANGPAI_ADDDANGPAI("003-003","添加党派成员失败"),
    DANGPAI_UPDATEDANGPAI("003-004","修改党派成员失败"),
    DANGPAI_DELTEDANGPAI("003-005","删除党派成员失败");
    /*DANGPAI_QUERYDANGPAIPART("003-006","查询党派成员部分信息失败")*/

    private String typeCode;
    private String message;

    AllEnum(String typeCode, String message) {
        this.typeCode = typeCode;
        this.message = message;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
