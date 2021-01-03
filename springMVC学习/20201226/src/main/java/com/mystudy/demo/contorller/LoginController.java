package com.mystudy.demo.contorller;

import com.mystudy.demo.model.ResponseJson;
import com.mystudy.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class LoginController {

    //登录操作
    @RequestMapping("/login")
    public ResponseJson login(User user, HttpServletRequest request) {//请求数据类型为json
        ResponseJson json = new ResponseJson();
        //调用service完成用户登录请求
        //模拟通过service得到用户登录操作的返回结果
        if ("abc".equals(user.getUsername())) {
            //通过请求头Cookie：JSESSIONID=xxx，在服务端map中通过xxx查找session
            //找到session就返回，没找到就创建一个
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            json.setSuccess(true);
        }else {
            json.setSuccess(false);
            json.setMessage("用户登录错误");
            json.setCode("LOG444");
        }
        return json;
    }
}
