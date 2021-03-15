package com.lkimilhol.matchingProject.exception;

public enum ErrorInfo {
    SUCCESS(200, "success")
    , INVALID_PARAMETER(-99, "invalid parameter")
    ,
    ;

    int code;
    String message;

    ErrorInfo(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getErrorCode() {
        return this.code;
    }

    public String getErrorMessage() {
        return this.message;
    }
}
