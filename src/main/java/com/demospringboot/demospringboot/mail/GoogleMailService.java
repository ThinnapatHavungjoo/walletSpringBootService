/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.mail;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author thinnapath
 */
public class GoogleMailService implements MailService {
    
    @Value("$(mail-provider.googlemail.url)")
    private String url;
    @Value("$(mail-provider.googlemail.url-port)")
    private String port;

    public GoogleMailService() {

    }
    
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public void setPort(String port) {
//        this.port = port;
//    }
    
    public void sendEmail(String to, String body) {
        System.out.println("Sent by google: " + url + ":" + port);
    }
    
}
