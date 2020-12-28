package com.mystudy.controller;


import com.mystudy.exception.AgeException;
import com.mystudy.exception.MyUserException;
import com.mystudy.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {


    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,Integer age) throws MyUserException {
        System.out.println("name=="+name+" age=="+age);
        ModelAndView mv = new ModelAndView();

        //根据请求参数抛出异常
        if (!"zs".equals(name)){
            throw new NameException("姓名不正确");
        }

        if (age == null || age > 80) {
            throw new AgeException("年龄太大");
        }

        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }


}
