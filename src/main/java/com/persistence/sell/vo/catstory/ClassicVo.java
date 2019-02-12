package com.persistence.sell.vo.catstory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClassicVo {

    @JsonProperty("content")
    private String content;

    @JsonProperty("fav_nums")
    private Integer favNums;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("image")
    private String image;

    @JsonProperty("index")
    private Integer index; // 期号

    @JsonProperty("like_status")
    private Boolean likeStatus; // 是否点赞

    @JsonProperty("pubdate")
    private LocalDate pubdate; // 发布日期

    @JsonProperty("title")
    private String title;

    @JsonProperty("type")
    private Integer type; // 期刊类型 100 电影 200 音乐 300 句子

}
