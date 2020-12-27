package com.mystudy.controller;

import com.mystudy.entity.Student;
import com.mystudy.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StudentController {

    @Resource
    private StudentService service;

    //学生注册
    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView mv = new ModelAndView();

        String tip = "注册失败!";

        //调用service完成学生注册功能
        int res = service.addStudent(student);
        if (res == 1) {
            tip = "学生【"+student.getName()+"】注册成功!";
        }
        mv.addObject("tip",tip);
        mv.setViewName("result");
        return mv;
    }

    //学生查询，响应ajax
    @RequestMapping("/listStudent.do")
    @ResponseBody
    public List<Student> findStudents() {
        //调用service完成学生查询功能
        List<Student> res = service.findStudents();
        return res;
    }
}
