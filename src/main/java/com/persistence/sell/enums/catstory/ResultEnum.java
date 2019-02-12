package com.persistence.sell.enums.catstory;

import lombok.Getter;

@Getter
public enum ResultEnum {
    // 100x 通用类型
    PUBLIC_ERR_ARGS(1000, "输入参数错误"),
    PUBLIC_ERR_FORMAT(1001,"输入的json格式不正确"),
    PUBLIC_ERR_RESOURCE_NOT_FOUND(1002,"找不到资源"),
    PUBLIC_ERR_UNKNOW(1003,"未知错误"),
    PUBLIC_ERR_FORBIDDEN(1004,"禁止访问"),
    PUBLIC_ERR_UNAUTHORIZED(1005,"不正确的开发者key"),
    PUBLIC_ERR_INTERNAL_SERVER_ERROR(1006,"服务器内部错误"),
    // 200x 点赞类型
    LIKE_ERR_YES(2000,"你已经点过赞了"),
    LIKE_ERR_NO(2001,"你还没点过赞"),
    // 300x 期刊类型
    CLASSIC_ERR_NOT_EXIST(3000,"该期内容不存在")
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
