package com.example.lms.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdivice {

    @ExceptionHandler(LibExceptions.class)
    public String  mapException(){

        return "error";
    }



}
