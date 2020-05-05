package com.greetingapp.service;

import com.greetingapp.dto.Greeting;
import com.greetingapp.dto.User;
import com.greetingapp.repository.IGreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;


@Service
public class GreetingServiceImpl implements IGreetingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    IGreetingRepository greetingRepository;

    private AtomicInteger counter;

    @Override
    public String getGreeting(String... name) {
        if (name.length == 1) {
            return "Hello " + name[0];
        }
        if (name.length == 2)
            return "Hello " + name[0] + " " + name[1];
        return "Hello World";
    }

    @Override
    public Greeting addGreeting(User user) {
        String message = "Hello";
        message = user.toString().isEmpty() ? "Hello World" : user.getFirstName() + " " + user.getLastName();
        Greeting greeting = modelMapper.map(new Greeting(counter.incrementAndGet(), message), Greeting.class);
        return greetingRepository.save(greeting);
    }
}