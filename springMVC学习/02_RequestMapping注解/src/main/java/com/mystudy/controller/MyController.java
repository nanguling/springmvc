package com.mystudy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @RequestMapping:
 *      value：所有请求地址的公共部分，叫作模块名称
 *      位置：放在类的上面
 */
@RequestMapping("/test")
@Controller
public class MyController {

    /**
     * @RequestMapping：请求映射
     *      属性：method，表示请求方式。它的值是RequestMethod类枚举值
     *           例如get请求方式为RequestMethod.GET
     * @return
     */
    //指定some.do使用get的请求方式
    @RequestMapping(value = "/some.do",method = RequestMethod.GET)
    public ModelAndView doSome() { //doGet()---service处理请求
        //处理some.do的请求，相当于service调用处理完成了。
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","第一次使用springmvc开发web项目");
        mv.setViewName("show");
        return mv;
    }

    //指定other.do使用post请求方式
    @RequestMapping(value = "/other.do",method = RequestMethod.POST)
    public ModelAndView doOther() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","===第一次使用springmvc开发web项目===");
        mv.setViewName("other");
        return mv;
    }

    //不指定请求方式，默认支持所有请求方式
    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","===第一次使用springmvc开发web项目==="+request.getParameter("name"));
        mv.setViewName("other");
        return mv;
    }
}
