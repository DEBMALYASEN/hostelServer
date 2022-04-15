package com.hostel.hostelPortal.service;

import com.hostel.hostelPortal.model.User;
import com.hostel.hostelPortal.model.UserRole;

import java.util.Set;

public interface UserService {
    // creating user
    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    User getUser(String username);

    //delete user by id
    void deleteUser(Long userId);

    //update user by id
    void updateUser(User user);
}
