/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.exception;

/**
 *
 * @author thinnapath
 */
public class DuplicationException extends RuntimeException {
    
    public DuplicationException(String message) {
        super(message);
    }
}
