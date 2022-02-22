package com.pg.backend.quiz.spring.security.ss.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class User {
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    String username;
    String password;
    String email;

}
