package com.mystudy.handler;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器类：拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {

    //验证登陆的用户信息，正确应该return true，其他return false
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器代码执行");
        String loginName = "";
        //从session中获取name的值
        Object res = request.getSession().getAttribute("name");

        if (res != null) {
            loginName = (String) res;
        }

        //判断是否为zs，即是否满足权限
        if (!"zs".equals(loginName)) {
            //权限不足，不能访问
            //跳转页面给用户提示
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }

        //权限满足可以访问
        return true;
    }
}