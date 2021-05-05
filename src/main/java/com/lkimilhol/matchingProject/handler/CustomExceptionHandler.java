package com.lkimilhol.matchingProject.handler;

import com.lkimilhol.matchingProject.exception.CustomException;
import com.lkimilhol.matchingProject.exception.ErrorInfo;
import com.lkimilhol.matchingProject.response.ResultBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public @ResponseBody
    ResponseEntity<ResultBody> exceptionHandler(CustomException e) {
        ResultBody resultBody = ResultBody.builder()
                .serverCode(e.getErrorInfo().getErrorCode())
                .serverMsg(e.getErrorInfo().getErrorMessage())
                .build();
        System.out.println(e.getErrorInfo().getErrorMessage());
        return new ResponseEntity<>(resultBody, HttpStatus.OK);
    }

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody
    ResponseEntity<ResultBody> exceptionHandler(Exception e) {
        ResultBody resultBody = ResultBody.builder()
                .serverCode(ErrorInfo.NOT_DEFINE_SERVER_ERROR.getErrorCode())
                .serverMsg(e.getMessage())
                .build();
        System.out.println(e.getMessage());
        return new ResponseEntity<>(resultBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
