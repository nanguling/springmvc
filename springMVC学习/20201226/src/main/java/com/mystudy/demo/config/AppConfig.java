package com.mystudy.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mystudy.demo.handler.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置mvc的启动配置类
@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private ObjectMapper mapper;

    //配置Controller中请求映射方法路径匹配规则
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //设置路径前置的规则，以第二个参数的返回值作为请求映射方法是否添加前缀
        configurer.addPathPrefix("api",c->true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //前端处理逻辑与后端处理逻辑不一样
        //前端：敏感资源在拦截器中处理为：没登陆跳转首页
        //后端：敏感资源在拦截器中处理为：返回json，状态码401
        registry.addInterceptor(new LoginHandler(mapper))
                //所有后端非/user/开头，只有指定的两个指定
                .addPathPatterns("/api/**")
                .excludePathPatterns("api/user/**")//后端开放的资源
                .addPathPatterns("view/article.html")
                .addPathPatterns("view/main.html");
    }
}
