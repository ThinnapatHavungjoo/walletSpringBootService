/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.exception;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;

/**
 *
 * @author thinnapath
 */
public class ApiExceptionResponse {
    
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime dateTime;
    
    public ApiExceptionResponse(String message, HttpStatus httpStatus, ZonedDateTime dateTime) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.dateTime = dateTime;
    }
    
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }
    
}
