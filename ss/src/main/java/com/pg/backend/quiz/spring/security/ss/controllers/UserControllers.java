package com.pg.backend.quiz.spring.security.ss.controllers;

import com.pg.backend.quiz.spring.security.ss.models.User;
import com.pg.backend.quiz.spring.security.ss.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllers {

    @Autowired
    private UserServices userServices;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userServices.listAllUser();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return userServices.getUserById(username);
    }
    @PostMapping("/add")
    public User addUser(User user){
        return userServices.addUser(user);
    }



}