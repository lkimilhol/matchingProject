package com.lkimilhol.matchingProject.exception;

public enum ErrorInfo {
    SUCCESS(200, "success")
    , NOT_DEFINE_SERVER_ERROR(-99, "server error")
    , INVALID_PARAMETER(-98, "invalid parameter")
    , REDIS_CONNECT_ERROR(-97, "redis connect error")

    //회원
    , DUPLICATED_NICKNAME(100, "duplicated nickname")
    , NOT_EXISTS_MEMBER(101, "not exists member by nickname")

    //가게
    , NOT_EXISTS_SHOP(200, "not exists shop by nickname")

    //주문
    , INVALID_AMOUNT(300, "amount can not be negative")
    , INVALID_SHOP_MENU(301, "invalid shop menu")
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
