package com.demospringboot.demospringboot;

import com.demospringboot.demospringboot.mail.GoogleMailService;
import com.demospringboot.demospringboot.mail.MailService;
import com.demospringboot.demospringboot.mail.OutlookMailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class DemospringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemospringbootApplication.class, args);
	}
                
        @Bean
        @Primary
        public MailService googleMail() {
            return new GoogleMailService();
        }
        
        @Bean 
        public MailService outlookMail(){
            return new OutlookMailService();
        }

}
