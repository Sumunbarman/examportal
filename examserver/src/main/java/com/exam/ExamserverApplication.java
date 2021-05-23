package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import com.exam.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Staring Code");
		User user = new User();
		user.setFirstName("Sumun");
		user.setLastName("Barman");
		user.setEmail("admin@gmail1.com");
		user.setPassword("aaa");
		user.setUserName("admin@gmail1.com");
		user.setProfile("Default.png");
		user.setPhone("6751987931");

		Role role =new Role();
		role.setRoleId(44L);
		role.setRoleName("ADMIN");

		Set<UserRole> userRolesSet = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		User user1 = this.userService.createUser(user,userRolesSet);
		System.out.println(user1.getUserName());
	}
}
