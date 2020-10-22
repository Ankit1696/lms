package com.example.lms.exceptions;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdivice {

    @ExceptionHandler(LibExceptions.class)
    public String  mapException(){

        return "error";
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String invalidInput(MethodArgumentNotValidException ex) {
       return "error";
    }

    /**
     * This exception is thrown if the input parameters does not justify the entity class relation.
     * For example if a integer value is supplied with string parameters: this exception is thrown.
     * @param ex
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public String invalidInput(HttpMessageNotReadableException ex) {
        return "error";
    }

    /**
     * This exception is thrown if the input parameters name is not defined in our accepted input parameters
     * For example: sort value input was not present as a column in our entity
     * @param ex
     * @return
     */
    @ExceptionHandler(PropertyReferenceException.class)
    public String invalidInput(PropertyReferenceException ex) {
        return "error";
    }

}
