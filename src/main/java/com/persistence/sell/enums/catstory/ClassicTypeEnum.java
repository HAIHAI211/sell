package com.persistence.sell.enums.catstory;

import lombok.Getter;

@Getter
public enum ClassicTypeEnum {
    MOVIE(100, "电影"),
    MUSIC(200, "音乐"),
    SENTENCE(300, "句子")
    ;
    private Integer code;
    private String message;

    ClassicTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
