package com.mystudy.demo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mystudy.demo.model.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * 执行完controller的请求映射方法，如果是有响应体内容的，可以在写入http协议响应体之前，重写
     * @param o 请求映射方法返回值
     * @param serverHttpResponse springmvc封装的一个响应类
     * @return 返回的响应体内容：一般的做法，请求映射返回Object，可以改为其他对象
     *                                        返回String，使用json序列化
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果请求映射方法返回统一响应的的格式，就不需要再次包裹
        if (o instanceof ResponseJson)
            return o;
        //包裹为统一的响应格式
        ResponseJson json = new ResponseJson();
        json.setSuccess(true);
        json.setData(o);
        //如果是String，需要序列化
        if (o instanceof String) {
            try {
                String res = objectMapper.writeValueAsString(json);
                return res;
            } catch (JsonProcessingException e) {
                throw new RuntimeException("json序列化失败"+json);
            }
        }
        return json;
    }
}
