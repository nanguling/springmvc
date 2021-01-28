package com.mystudy.mapper;

import com.mystudy.base.BaseMapper;
import com.mystudy.model.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}