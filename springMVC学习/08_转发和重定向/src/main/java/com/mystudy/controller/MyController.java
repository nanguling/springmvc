package com.mystudy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {


    /**
     * 处理器方法返回ModelAndView，实现转发操作
     * 语法：setViewName("forward:视图文件完整路径")
     * 特点：不和视图解析器一起使用，就当项目中没有视图解析器
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doForward(String name,Integer age) {
        System.out.println("name=="+name+" age=="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        //forward显示转发
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;
    }


    /**
     * 处理器方法返回ModelAndView，实现重定向
     * 语法：setViewName("redirect:试图完整路径")
     * 特点：不和视图解析器一起使用，就当项目中没有视图解析器
     *
     * 框架对重定向的操作：
     *  1.框架会把Model中的简单类型数据，转为字符串使用，作为hello.jsp的get请求参数使用
     *    目的是在 doRedirect.do 和 hello.jsp 两次请求之间传递数据
     *
     *  2.在目标hello.jsp页面可以使用参数集合对象 ${param}获取请求参数值
     *    ${param.myname}
     *
     *  3.重定向不能访问WEB-INF下的资源
     */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doRedirect(String name,Integer age) {
        System.out.println("name=="+name+" age=="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //redirect显示重定向
        //mv.setViewName("redirect:/hello.jsp");

        //重定向不能访问WEB-INF下的资源
        mv.setViewName("redirect:/WEB-INF/view/show.jsp");
        return mv;
    }
}
