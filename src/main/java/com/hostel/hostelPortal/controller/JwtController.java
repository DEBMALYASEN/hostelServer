package com.hostel.hostelPortal.controller;


import com.hostel.hostelPortal.jwt.service.CustomUserDetailsService;
import com.hostel.hostelPortal.jwt.util.JwtUtil;
import com.hostel.hostelPortal.model.JwtRequest;
import com.hostel.hostelPortal.model.JwtResponse;
import com.hostel.hostelPortal.model.User;
import com.hostel.hostelPortal.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class JwtController
{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserRepository userRepository;



    @Autowired
    private JwtUtil jwtUtil;



    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
    {
        System.out.println(jwtRequest);
        try
        {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

        }catch(UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials - username not found");
        }catch(BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT token is "+token);

        JwtResponse jwtResponse = new JwtResponse();
        System.out.println(jwtRequest.getUsername());



        User user = userRepository.findByUserName(jwtRequest.getUsername());
        System.out.println(user.getUsername());
        jwtResponse.setToken(token);
        jwtResponse.setFname(user.getFirstName());
        jwtResponse.setLname(user.getLastName());
        jwtResponse.setUsername(user.getUsername());
        jwtResponse.setId(user.getId());
        jwtResponse.setEnabled(user.isEnabled());
        return ResponseEntity.ok(jwtResponse);
    }
}