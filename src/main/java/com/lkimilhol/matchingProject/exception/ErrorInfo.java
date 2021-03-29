package com.lkimilhol.matchingProject.exception;

public enum ErrorInfo {
    SUCCESS(200, "success")
    , NOT_DEFINE_SERVER_ERROR(-99, "server error")
    , INVALID_PARAMETER(-98, "invalid parameter")

    //회원
    , DUPLICATED_NICKNAME(100, "duplicated nickname")
    , NOT_EXISTS_MEMBER(101, "not exists member by nickname")
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
