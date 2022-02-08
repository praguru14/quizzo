package com.pg.backend.quiz.controllers;

import com.pg.backend.quiz.models.RoleModel;
import com.pg.backend.quiz.models.UserModel;
import com.pg.backend.quiz.models.UserRole;
import com.pg.backend.quiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    private UserService userService;
    @PostMapping("/")
    public UserModel createUser(@RequestBody UserModel user) throws Exception {

        Set<UserRole> userRoleSet = new HashSet<>();



        RoleModel role = new RoleModel();
        role.setId(45L);
        role.setRoleName("USER");

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        return userService.createUser(user,userRoleSet);
    }

    @GetMapping("/{username}")
    public UserModel getUser(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
    }

}
