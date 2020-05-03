package com.greetingapp.service;

public interface IGreetingService {
    String getGreeting();

    String getGreetingWithFirstName(String firstName);

    String getGreetingWithLastName(String lastName);

    String getGreetingWithFullName(String lastName);
}
