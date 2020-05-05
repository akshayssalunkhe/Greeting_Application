package com.greetingapp.service;

import com.greetingapp.dto.Greeting;
import com.greetingapp.dto.User;

public interface IGreetingService {
    String getGreeting(String... name);
    Greeting addGreeting(User user);
}
