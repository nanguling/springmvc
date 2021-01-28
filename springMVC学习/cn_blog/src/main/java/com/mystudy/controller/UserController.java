package com.mystudy.controller;

import com.mystudy.exception.AppException;
import com.mystudy.model.User;
import com.mystudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public Object login(User user, HttpServletRequest request) {
        //浏览器输入的账号密码，先根据账号查出用户
        User ifExist = service.query(user.getUsername());

        if (ifExist != null) {
            if (ifExist.getPassword().equals(user.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user",ifExist);
                return null;
            }else {
                throw new AppException("LOG444","密码错误");
            }
        }else {
            throw new AppException("LOG404","用户不存在");
        }
    }
}
