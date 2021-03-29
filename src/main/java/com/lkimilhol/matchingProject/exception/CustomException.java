package com.lkimilhol.matchingProject.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class CustomException extends RuntimeException{
    private ErrorInfo errorInfo;
    private Object[] args;


    public CustomException(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }

    public CustomException(ErrorInfo errorCode, Object... args) {
        this.errorInfo = errorCode;
        this.args = args;
    }

    public ErrorInfo getErrorInfo() {return errorInfo;}
}
