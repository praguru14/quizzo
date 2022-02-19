package com.pg.backend.quiz.services;

import com.pg.backend.quiz.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsSecurityService implements UserDetailsService {


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserModel user = userService.findByUsername(username);
       if(user==null){
           System.out.println("User not found");
           throw new UsernameNotFoundException("No User found with these credentials");
       }
        return user;
    }
}
