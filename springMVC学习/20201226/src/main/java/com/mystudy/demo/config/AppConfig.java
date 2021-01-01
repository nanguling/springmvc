package com.mystudy.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//配置mvc的启动配置类
@Configuration
public class AppConfig implements WebMvcConfigurer {
    //配置Controller中请求映射方法路径匹配规则
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //设置路径前置的规则，以第二个参数的返回值作为请求映射方法是否添加前缀
        configurer.addPathPrefix("api",c->true);
    }
}
