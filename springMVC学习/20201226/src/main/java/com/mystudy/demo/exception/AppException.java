package com.mystudy.demo.exception;

//自定义异常：保存错误码和错误消息
public class AppException extends RuntimeException {
    private String code;

    public AppException(String code, String message) {
        super(message);
        this.code = code;
    }

    public AppException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
