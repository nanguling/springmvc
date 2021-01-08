package com.mystudy.demo.config;

import com.mystudy.demo.contorller.TestArgumentController;
import com.mystudy.demo.exception.AppException;
import com.mystudy.demo.model.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @ControllerAdvice：方法上可以使用@ExceptionHandler处理异常
 * @RestControllerAdvice：由@ControllerAdvice和@ResponseBody组成
 */
@ControllerAdvice
public class ExceptionAdvice {

    private static final Logger log = LoggerFactory.getLogger(TestArgumentController.class);

    @ExceptionHandler(AppException.class)
    @ResponseBody
    //自定义异常保存错误码和错误消息
    public Object exceptionAdvice(AppException e) {
        ResponseJson json = new ResponseJson();
        json.setCode(e.getCode());
        json.setMessage(e.getMessage());
        //log.debug(transfer(e));
        log.debug("自定义异常",e);
        return json;
    }

    //非自定义异常（英文错误信息，不能给用户看）：指定一个错误码，错误消息（未知错误...）
    @ExceptionHandler(Exception.class)
    @ResponseBody
    //自定义异常保存错误码和错误消息
    public Object exceptionAdvice2(Exception e) {
        ResponseJson json = new ResponseJson();
        json.setCode("ER444");
        json.setMessage("未知错误，请联系管理员");
        //log.debug(transfer(e));
        log.error("未知错误",e);
        return json;
    }

    public static String transfer(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw,true);//true表示自动刷新缓冲区信息
        e.printStackTrace(out);//打印异常堆栈信息到PrintWriter
        return sw.toString();
    }
}
