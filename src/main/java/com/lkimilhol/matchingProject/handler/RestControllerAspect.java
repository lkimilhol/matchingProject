package com.lkimilhol.matchingProject.handler;

import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.response.ResultBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAspect {

    @ExceptionHandler(CustomException.class)
    public @ResponseBody
    ResultBody exceptionHandler(ErrorInfo errorInfo) {
        System.out.println("exception");
        return ResultBody.builder()
                .serverCode(errorInfo.getErrorCode())
                .serverMsg(errorInfo.getErrorMessage())
                .build();
    }

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody
    ResultBody exceptionHandler(Exception e) {
        System.out.println("exception");
        return ResultBody.builder()
                .serverCode(ErrorInfo.NOT_DEFINE_SERVER_ERROR.getErrorCode())
                .serverMsg(e.getMessage())
                .build();
    }
}
