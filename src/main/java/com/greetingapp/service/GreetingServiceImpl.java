package com.greetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements IGreetingService {
    @Override
    public String getGreeting() {
        return "Hello World";
    }

    @Override
    public String getGreetingWithFirstName(String firstName) {
        return ("Hello" + " " + firstName);
    }

    @Override
    public String getGreetingWithLastName(String lastName) {
        return ("Hello" + " " + lastName);
    }

    @Override
    public String getGreetingWithFullName(String fullName) {
        return ("Hello" + " " + fullName);
    }
}