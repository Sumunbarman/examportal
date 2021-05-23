package com.exam.controller;

import com.exam.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class UserController {

//create user
    @PostMapping("/")
    public User CreateUser(@RequestBody User user){
        
    }
}

