package com.mystudy.service;

import com.mystudy.mapper.ArticleMapper;
import com.mystudy.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper mapper;

    public List<Article> queryAll() {
        return mapper.queryAll();
    }
}
