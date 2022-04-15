package com.hostel.hostelPortal.controller;

import com.hostel.hostelPortal.model.EmailRequest;
import com.hostel.hostelPortal.model.EmailResponse;
import com.hostel.hostelPortal.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EmailController {
    @Autowired
    private EmailService emailService;
    @RequestMapping("/welcome")
    public String welcome()
    {
        return "hello this is my email api";
    }

    //api to send email
    @RequestMapping(value="/sendemail",method= RequestMethod.POST)
    //<?> means you don't want want mention type
    //@RequestBody helps in storing JSON data
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
    {
        boolean result=this.emailService.sendEmail(request.getMessage(), request.getSubject(), request.getTo());
        if(result)
        {
            System.out.println(request);
            return ResponseEntity.ok(new EmailResponse("Email sent successfully."));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not sent..."));
        }

    }
}
