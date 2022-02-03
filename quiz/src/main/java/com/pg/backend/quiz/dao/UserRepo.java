package com.pg.backend.quiz.dao;

import com.pg.backend.quiz.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserModel,Long> {
    UserModel findByUsername(String username);
}
