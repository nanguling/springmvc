package com.mystudy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {


    //不指定请求方式，默认支持所有请求方式
    @RequestMapping(value = "/test/first.do")
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","===第一次使用springmvc开发web项目==="+request.getParameter("name"));
        mv.setViewName("/index.jsp");
        return mv;
    }
}
