package com.pg.backend.quiz.services;

import com.pg.backend.quiz.models.UserModel;
import com.pg.backend.quiz.models.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {
    public UserModel createUser(UserModel userModel, Set<UserRole> userRoles) throws Exception;
    public UserModel findByUsername(String username);
    public void deleteById(Long id);

}
