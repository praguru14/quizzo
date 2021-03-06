package com.pg.backend.quiz.services;

import com.pg.backend.quiz.dao.RoleRepo;
import com.pg.backend.quiz.dao.UserRepo;
import com.pg.backend.quiz.models.UserModel;
import com.pg.backend.quiz.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public UserModel createUser(UserModel userModel, Set<UserRole> userRoles) throws Exception {
        UserModel userByName = this.userRepo.findByUsername(userModel.getUsername());
        if(userByName !=null){
            System.out.println("User already present");
            throw new Exception("User already present");
        }
        else{
            for(UserRole ur : userRoles){
                roleRepo.save(ur.getRole());
            }
            userModel.getUserRoles().addAll(userRoles);
            userByName=this.userRepo.save(userModel);
        }
        return userByName;
    }
    //getting user by username
    @Override
    public UserModel findByUsername(String username) {
    return userRepo.findByUsername(username);
    }

    @Override
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }
}
