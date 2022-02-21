package com.pg.backend.quiz.controllers;

import com.pg.backend.quiz.models.JwtRequest;
import com.pg.backend.quiz.models.JwtResponse;
import com.pg.backend.quiz.services.UserDetailsSecurityService;
import com.pg.backend.quiz.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsSecurityService userDetailsSecurityService;

    @Autowired
    private JwtUtils jwtUtils;



    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());
        UserDetails userDetails = userDetailsSecurityService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtUtils.generateToken(userDetails);
        System.out.println("Token is"+ token);
        return ResponseEntity.ok(new JwtResponse(token));

    }

    private void authenticate(String username,String password) throws Exception {
    try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
    }
    catch (Exception e)
    {
        throw new Exception("Something is wrong");
    }
    }

}
