/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.exception;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author thinnapath
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse (
                notFoundException.getMessage(),
              HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        
        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = {DuplicationException.class})
    public ResponseEntity<Object> handleDuplicationException(DuplicationException duplicationException) {
        
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse (
                duplicationException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        
        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
