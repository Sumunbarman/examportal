package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.Set;
public interface UserService
{

    //creating user
    public User createUser(User user, Set<UserRole> userRoles);

    //get User
    public User getUser(String userName);

    //getDelete
    public  void deleteUser(Long userId);
}
