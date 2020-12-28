package com.mystudy.exception;

//当用户姓名有异常抛出NameException
public class NameException extends MyUserException {
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
