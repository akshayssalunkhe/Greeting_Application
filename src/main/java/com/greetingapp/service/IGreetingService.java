package com.greetingapp.service;

import com.greetingapp.dto.Greeting;
import com.greetingapp.dto.User;

import java.util.List;

public interface IGreetingService {

    Greeting addGreeting(User user);

    Greeting getGreeting(long id);

    void deleteGreeting(long id);

    List<Greeting> getAllGreeting();

    Greeting updateGreeting(long id, String message);
}
