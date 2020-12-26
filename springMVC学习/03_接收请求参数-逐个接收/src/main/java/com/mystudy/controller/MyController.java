package com.mystudy.controller;


import com.mystudy.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @RequestMapping:
 *      value：所有请求地址的公共部分，叫作模块名称
 *      位置：放在类的上面
 */
@Controller
public class MyController {

    /**
     * 逐个接收请求参数：
     *  要求：处理器（控制器）方法的形参名和请求中参数名必须一致
     *       同名的请求参数赋值给同名的形参
     *
     * 框架接收请求参数：
     *  1.使用request对象接受请求参数
     *      String name = request.getParmter("name");
     *      String age = request.getParmter("age");
     *  2.springmvc框架通过DispatherServlet调用MyController的doSome()方法
     *    调用方法时，按名称对应，把接收的参数赋给形参
     *    doSome(name,Integer.valueOf(age))
     *    框架会提供类型转换的功能
     *
     * 400状态码：是客户端错误，表示在提交请求参数过程中发生了问题。
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String  name,Integer age) {
        //可以在方法中直接使用name，age
        System.out.println("name=="+name+" age=="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 请求中参数名和处理器方法的形参名不一样
     * @RequestParam：逐个接收请求参数中解决请求中参数名和形参名不一样的问题
     *      属性：
     *          1.value：请求中参数名称
     *          2.required：布尔类型，默认true，表示请求中必须包含此参数，没有就报错400
     *      位置：在处理器方法的形参定义的前面
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveParam(@RequestParam(value = "rname",required = false) String  name,
                                     @RequestParam(value = "rage",required = false) Integer age) {
        //可以在方法中直接使用name，age
        System.out.println("name=="+name+" age=="+age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }

    /**
     * 处理器方法形参是java对象，这对象的属性名和请求参数名是一样的
     * 框架会创建形参的java对象，给属性赋值。请求参数是name，框架会调用setName()
     * @return
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveObject(Student student) {
        //可以在方法中直接使用name，age
        System.out.println("name=="+student.getName()+" age=="+student.getAge());
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",student.getName());
        mv.addObject("age",student.getAge());
        mv.addObject("student",student);
        mv.setViewName("show");
        return mv;
    }
}
