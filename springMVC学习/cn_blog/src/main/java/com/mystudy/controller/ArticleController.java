package com.mystudy.controller;

import com.mystudy.data.Data;
import com.mystudy.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    //显示所有文章信息：还需要用户信息告诉前端是否登录
    //一般响应的数据格式：使用已有的模型，或创建新的模型
    @RequestMapping("/query")
    public Object query(HttpServletRequest request) {
        User user = null;
        HttpSession session = request.getSession(false);
        if (session != null) {
            User getUser = (User) session.getAttribute("user");
            if (getUser != null) {
                user = getUser;
            }
        }
        //返回的数据
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("articles", Data.allArticles());
        return map;
    }
}
