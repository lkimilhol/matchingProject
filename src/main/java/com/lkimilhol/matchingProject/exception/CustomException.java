package com.lkimilhol.matchingProject.exception;

public class CustomException extends Exception {
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

    public void setErrorCode(int errorCode) {
        this.errorInfo.code = errorCode;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}