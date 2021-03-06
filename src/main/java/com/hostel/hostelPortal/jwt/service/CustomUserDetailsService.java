package com.hostel.hostelPortal.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService
{



    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

        if(username.equals("student"))
            return new User("student", "admin", new ArrayList<>());
        else{
            throw new UsernameNotFoundException("User Not found");
        }
    }
}