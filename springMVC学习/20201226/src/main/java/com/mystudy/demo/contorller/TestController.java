package com.mystudy.demo.contorller;

import com.mystudy.demo.model.ResponseJson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/1")
    public String test01() {
        //请求转发：只有一次请求，地址栏不变，服务端把资源作为响应体直接返回
        return "forward:/home.html";
    }

    @RequestMapping("/2")
    public String test02() {
        //重定向：至少2次请求，地址栏改变，响应302状态码，浏览器自动跳转
        return "redirect:/home.html";
    }

    @RequestMapping("/3")
    @ResponseBody
    public String test03() {
        //重定向：至少2次请求，地址栏改变，响应302状态码，浏览器自动跳转
        return "redirect:/home.html";
    }

    @RequestMapping("/4")
    @ResponseBody
    public Object test4(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王五");
        return map;
    }

    @RequestMapping(value = "/5",method = {RequestMethod.GET,RequestMethod.POST})//只提供get和post请求
    @ResponseBody
    public Object test5(){
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("data","[{'id':1,'name':'lisi','age':18},{'id':2,'name':'zhangsan','age':20}]");
        return map;
    }

    @RequestMapping("/6")
    @ResponseBody
    public Object test6(){
        ResponseJson rj = new ResponseJson();
        rj.setCode("444");
        rj.setData(new Date());
        rj.setMessage("xxxx");
        rj.setSuccess(true);
        return rj;
    }

    @RequestMapping("/7")
    @ResponseBody
    public Object test7(){
        ResponseJson rj = new ResponseJson();
        rj.setCode("444");
        rj.setData(new Date());
        rj.setMessage("xxxx");
        rj.setSuccess(true);
        return ResponseEntity.status(401).body(rj);
    }
}
