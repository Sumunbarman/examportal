package com.exam.controller;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/public")
public class UserController {

    @Autowired
    private UserService userService;


//create user
    @PostMapping("/")
    public User CreateUser(@RequestBody User user) throws  Exception{

        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45l);
        role.setRoleName("NORMAL");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return this.userService.createUser(user, roles);
    }

    //get User
    @GetMapping("/{userName}")
    public  User getUser(@PathVariable("userName") String userName)
    {
        return this.userService.getUser(userName);
    }

    //delete User
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }
}