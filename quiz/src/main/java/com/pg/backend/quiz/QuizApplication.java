package com.pg.backend.quiz;

import com.pg.backend.quiz.models.RoleModel;
import com.pg.backend.quiz.models.UserModel;
import com.pg.backend.quiz.models.UserRole;
import com.pg.backend.quiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting code");
//		UserModel user = new UserModel();
//		user.setFirstName("Prafull");
//		user.setLastName("Gururani");
//		user.setEmail("praguru14@gmail.com");
//		user.setUsername("praguru14");
//		user.setPassword("root");
//		user.setProfile_url("default.png");
//
//		RoleModel role1 = new RoleModel();
//		role1.setId(1L);
//		role1.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		userRoleSet.add(userRole);
//
//		UserModel userModel = userService.createUser(user,userRoleSet);
//		System.out.println(userModel.toString());
	}
}
