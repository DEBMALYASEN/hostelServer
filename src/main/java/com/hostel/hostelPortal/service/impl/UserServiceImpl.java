package com.hostel.hostelPortal.service.impl;

import com.hostel.hostelPortal.model.User;
import com.hostel.hostelPortal.model.UserRole;
import com.hostel.hostelPortal.repo.RoleRepository;
import com.hostel.hostelPortal.repo.UserRepository;
import com.hostel.hostelPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception{
        //to check if username is already present in DB or not?
        User local= this.userRepository.findByUserName(user.getUserName());
        if(local!=null)
        {
            System.out.println("User is already there !!");
            throw new Exception("User already present !!");
        }
        else
        {
            //create user
            for(UserRole ur:userRoles)
            {
                // only saved Role data into DB
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUserName(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(User user) {
        this.userRepository.save(user);
    }


}
