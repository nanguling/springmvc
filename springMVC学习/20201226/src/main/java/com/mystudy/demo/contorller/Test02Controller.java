package com.mystudy.demo.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test02Controller {

    @RequestMapping("/test01")
    public String test01() {
        //请求转发：只有一次请求，地址栏不变，服务端把资源作为响应体直接返回
        return "forward:/home.html";
    }

    @RequestMapping("/test02")
    public String test02() {
        //重定向：至少2次请求，地址栏改变，响应302状态码，浏览器自动跳转
        return "redirect:/home.html";
    }
}
