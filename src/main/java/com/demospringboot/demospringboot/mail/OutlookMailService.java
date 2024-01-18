/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.mail;

/**
 *
 * @author thinnapath
 */
public class OutlookMailService implements MailService {
    
    private String url;
    
    private String port;

    public OutlookMailService() {
    }
    

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    public void sendEmail(String to, String body) {
        System.out.println("Sent by outlook");
    }
    
}
