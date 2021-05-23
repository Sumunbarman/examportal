package com.exam.service.impl;

import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //Creating User
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User users = this.userRepository.findByUserName(user.getUserName());
        if (users != null){
            System.out.println("User Already Present with This Email !!");
            try {
                throw new Exception("User Already Present with This Email !!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        {
            for (UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            users = this.userRepository.save(user);
        }
    return users;
    }
}
