package com.mystudy.exception;

//当用户年龄有问题时抛出AgeException
public class AgeException extends MyUserException {
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
