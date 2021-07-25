package com.lkimilhol.matchingproject.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lkimilhol.matchingproject.exception.CustomException;
import com.lkimilhol.matchingproject.exception.ErrorInfo;
import com.lkimilhol.matchingproject.response.ResultBody;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public @ResponseBody
    ResponseEntity<ResultBody> exceptionHandler(CustomException e) {
        ResultBody resultBody = ResultBody.builder()
                .serverCode(HttpStatus.OK.value())
                .build();
        return new ResponseEntity<>(resultBody, HttpStatus.OK);
    }

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody
    ResponseEntity<ResultBody> exceptionHandler(Exception e) {
        ResultBody resultBody = ResultBody.builder()
                .serverCode(ErrorInfo.NOT_DEFINE_SERVER_ERROR.getErrorCode())
                .serverMsg(e.getMessage())
                .build();
        return new ResponseEntity<>(resultBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
