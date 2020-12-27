package com.mystudy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @RequestMapping:
 *      value：所有请求地址的公共部分，叫作模块名称
 *      位置：放在类的上面
 */
@Controller
public class MyController {

    /**
     * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     */
    @RequestMapping(value = "/some")
    public ModelAndView doSome(String  name, Integer age) {
        //可以在方法中直接使用name，age
        System.out.println("name=="+name+" age=="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }



}
