package com.example.spartafinalproject.controllers.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class IllegalAccessAdvice {
    @ResponseBody
    @ExceptionHandler(IllegalAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String httpMessageNotReadableHandler(IllegalAccessException e){
        String message = "Error while processing your request: ";
        return message+e;
    }

}
