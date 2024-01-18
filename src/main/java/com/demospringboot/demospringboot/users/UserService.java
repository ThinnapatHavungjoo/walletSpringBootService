/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.users;

import com.demospringboot.demospringboot.mail.MailService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 *
 * @author thinnapath
 */
@Component
public class UserService {
    
        List<User> users = new ArrayList<> (
            List.of(
                new User(1, "Ice", 26, true),
                new User(2, "Nhem", 26, true),
                new User(3, "Rin", 47, false)
            )
    );
        
        private final MailService mailService;
        
        public UserService(@Qualifier("googleMail")MailService mailService) {
            this.mailService = mailService;
        }
        
    public List<User> getUsers(Optional<Boolean> active){
        if (active.isPresent()) {
            return users.stream().filter(u -> u.getActive() == active.get()).toList();
        }
        return users;
    }
    
    public User createUser(UserRequest request) {
        Optional<Integer> maxId = users.stream().map(User::getId).max(Integer::compareTo);
        
        int nextId = maxId.orElse(0) + 1;
        
        User user = new User(nextId, request.name(), request.age(), true);
        users.add(user);
        
        //sent email
        mailService.sendEmail("dev@gmail.com", "User Created");
        
        return user;
    }
    
    public  void editUsers(int id, UserRequest request) {
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();
        if (user.isPresent()) {
            User u = user.get();
            u.setName(request.name());
        }
    }
    
    public void delete(int id) {
        users.removeIf(u -> u.getId() == id);
    }
}
