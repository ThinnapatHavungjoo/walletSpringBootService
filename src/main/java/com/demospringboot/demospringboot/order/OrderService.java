/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.order;

import com.demospringboot.demospringboot.mail.MailService;


/**
 *
 * @author thinnapath
 */
public class OrderService {
    private final MailService mailService;
    
    public OrderService(MailService mailService){
        this.mailService = mailService;
    }
    
    public void createOrder() {
        mailService.sendEmail("user@gmail.com", "Order created");
    }
}
