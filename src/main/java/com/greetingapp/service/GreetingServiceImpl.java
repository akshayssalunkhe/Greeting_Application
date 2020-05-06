package com.greetingapp.service;

import com.greetingapp.dto.Greeting;
import com.greetingapp.dto.User;
import com.greetingapp.repository.IGreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GreetingServiceImpl implements IGreetingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    IGreetingRepository greetingRepository;

    String template = "Hello %s";

    @Override
    public Greeting addGreeting(User user) {
        String message = (user.getFirstName().isEmpty() && user.getLastName().isEmpty()) ? String.format(template, "World") :
                (user.getFirstName().isEmpty()) ? String.format(template, user.getLastName()) :
                        (user.getLastName().isEmpty()) ? String.format(template, user.getFirstName()) :
                                String.format(template, user.getFirstName() + " " + user.getLastName());

        Greeting map = modelMapper.map(new Greeting(message), Greeting.class);
        return greetingRepository.save(map);
    }

    @Override
    public Greeting getGreeting(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public void deleteGreeting(long id) {
        greetingRepository.deleteById(id);
    }

    @Override
    public List<Greeting> getAllGreeting() {
        return greetingRepository.findAll();
    }

    public Greeting updateGreeting(long id, String message) {
        Greeting greeting = greetingRepository.findById(id).get();
        greeting.setMessage(message);
        return greetingRepository.save(greeting);
    }
}