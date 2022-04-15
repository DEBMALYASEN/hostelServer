package com.hostel.hostelPortal.service;

public interface EmailService
{
    boolean sendEmail(String message, String subject, String to);

}
