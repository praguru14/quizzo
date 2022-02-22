package com.pg.backend.quiz.spring.security.ss.services;

import com.pg.backend.quiz.spring.security.ss.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {
    List<User> userList = new ArrayList<>();
    public UserServices() {
        userList.add(new User("praguru14","root","praguru14@gmail.com"));
        userList.add(new User("abc","abc","abc@gmail.com"));
    }

    public List<User> listAllUser(){
        return userList;
    }

    public User getUserById(String username){
        return userList.stream().filter((user) ->user.getUsername().equals(username) ).findAny().orElse(null);
    }

    public User addUser(User user){
        userList.add(user);
        return user;
    }

}
