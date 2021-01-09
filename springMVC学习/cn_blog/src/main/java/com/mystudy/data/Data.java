package com.mystudy.data;

import com.mystudy.model.Article;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Article> allArticles() {
        List<Article> list = new ArrayList<>();
        Article article1 = new Article();
        article1.setId(1);
        article1.setTitle("薇姐");
        article1.setContent("14岁");
        Article article2 = new Article();
        article2.setId(2);
        article2.setTitle("薇妹");
        article2.setContent("15岁");
        Article article3 = new Article();
        article3.setId(3);
        article3.setTitle("薇尔莉特");
        article3.setContent("16岁");
        list.add(article1);
        list.add(article2);
        list.add(article3);
        return list;
    }
}
