package com.mystudy.mapper;

import com.mystudy.base.BaseMapper;
import com.mystudy.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> queryAll();
}