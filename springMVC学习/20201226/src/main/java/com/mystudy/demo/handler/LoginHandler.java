package com.mystudy.demo.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mystudy.demo.model.ResponseJson;
import com.mystudy.demo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


public class LoginHandler implements HandlerInterceptor {

    private ObjectMapper mapper;

    public LoginHandler(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在这这里验证用户登录请求是否具有合法性
        HttpSession session = request.getSession(false);
        if (session != null) {//获取登陆时设置的用户信息
            User user = (User) session.getAttribute("user");
            if (user != null) {//登录用户，允许访问
                return true;
            }
        }

        //登录失败，不允许访问的业务：区分前后端
        //获取请求的服务路径
        String uri = request.getRequestURI();
        if (uri != null) {
            if (!uri.contains("api")) {
                //相对路径的写法，一定是以请求路径作为相对位置的参照点
                //使用绝对路径来重定向，不建议使用相对路径和转发
                String schema = request.getScheme();//http
                String host = request.getServerName();//ip
                int port = request.getServerPort();//port
                String contextPath = request.getContextPath();//应用上下文路径
                String basePath = schema+"://"+host+":"+port+contextPath;
                response.sendRedirect(basePath);
            }else {
                //前端返回json字符串
                ResponseJson json = new ResponseJson();
                json.setSuccess(false);
                json.setMessage("恶意登陆");
                json.setCode("NOTLOG404");
                String res = mapper.writeValueAsString(json);
                //response.setStatus(401);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.println(res);
                out.flush();
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
