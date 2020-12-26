package com.mystudy.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mystudy.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @RequestMapping:
 *      value：所有请求地址的公共部分，叫作模块名称
 *      位置：放在类的上面
 */
@Controller
public class MyController {

    /**
     * 处理器方法返回String--表示逻辑视图名称，需要配置视图解析器
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/returnStringView.do")
    public String returnStringView(HttpServletRequest request, String  name, Integer age) {
        //可以在方法中直接使用name，age
        System.out.println("name=="+name+" age=="+age);

        //可以手动添加数据到request作用域
        request.setAttribute("name",name);
        request.setAttribute("age",age);

        //show:逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行forward转发操作
        return "show";
    }

    //处理器方法返回String，表示完整视图路径，此时不能配置视图解析器
    @RequestMapping(value = "/returnStringView2.do")
    public String returnStringView2(HttpServletRequest request, String  name, Integer age) {
        //可以在方法中直接使用name，age
        System.out.println("name2=="+name+" age2=="+age);

        //可以手动添加数据到request作用域
        request.setAttribute("name",name);
        request.setAttribute("age",age);

        //完整视图路径，项目中不能配置视图解析器
        //框架对视图执行forward转发操作
        ///WEB-INF/view/WEB-INF/view/show.jsp.jsp
        return "WEB-INF/view/show.jsp";
    }

    //处理器方法返回void，响应ajax请求
    //手动实现ajax，json数据：代码有重复 1.java对象转为json字符串；2.将json字符串写入响应体中
    @RequestMapping(value = "/returnVoidAjax.do")
    public void returnVoidAjax(HttpServletResponse response, String  name, Integer age) throws IOException {
        //可以在方法中直接使用name，age
        System.out.println("name2=="+name+" age2=="+age);

        //使用service处理ajax，使用json做数据的格式
        //假设service调用完成了，将结果转为Student对象
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        //将student对象序列化为json字符串
        String json = "";
        if (student != null) {
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
        }

        //将json字符串写入响应体返回给前端
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();

    }

    /**
     * 处理器方法返回Student，通过框架转为json，响应ajax请求
     *
     * @ResponseBody：把处理器方法返回的对象转为json后，通过响应对象写入响应体返回给前端
     *  位置：方法定义上面。和其他注解没有顺序的先后关系
     *
     * 返回对象框架的处理流程：
     *  1.框架会把返回值Student类型，调用框架中的ArrayList<HttpMessageConverter>中的每个类的canWrite方法
     *    来检查哪个消息转换器接口的实现类能处理Student类型的数据---MappingJackson2HttpMessageConverter。
     *  2.框架会调用实现类的write()方法--MappingJackson2HttpMessageConverter的write()方法
     *    把studebt对象转为json字符串，调用jackson中ObjectMapper实现
     *    Content-Type: application/json;charset=utf-8
     *  3.框架会调用@ResponseBody把得到的json结果输出给前端，ajax请求处理完成。
     */
    @ResponseBody
    @RequestMapping(value = "/returnStudentAjax.do")
    public Student doStudntJsonObject(String  name, Integer age) throws IOException {
        //调用service，获取请求结果数据，Student对象就表示结果数据
        Student student = new Student();
        student.setName("薇妹");
        student.setAge(15);
        return student;//会被框架转为json
    }

}
