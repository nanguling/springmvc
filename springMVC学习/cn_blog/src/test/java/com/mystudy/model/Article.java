package com.mystudy.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Article {
    
    private Integer id;

    private String title;

    private String content;

    private Integer userId;

    private Date createTime;

    private Integer viewCount;
}