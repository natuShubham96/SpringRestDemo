package com.shubham.spring.REST.webservices.SpringRESTDemo.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
