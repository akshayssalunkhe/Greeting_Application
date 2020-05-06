package com.greetingapp.controller;

import com.greetingapp.dto.Greeting;
import com.greetingapp.dto.User;
import com.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    IGreetingService greetingService;

    @GetMapping("/greeting/{id}")
    public Greeting greetingGet(@PathVariable long id) {
        return greetingService.getGreeting(id);
    }

    @RequestMapping("/greetingService")
    public List<Greeting> greetingList() {
        return greetingService.getAllGreeting();
    }

    @PutMapping("/updateGreeting/{id}")
    public Greeting greetingPut(@PathVariable long id, @RequestParam(value = "message") String message) {
        return greetingService.updateGreeting(id, message);
    }

    @PostMapping("/post")
    public Greeting greetingPost(@RequestBody User user) {
        return greetingService.addGreeting(user);
    }

    @RequestMapping("/deleteGreeting/{id}")
    public void deleteGreeting(@PathVariable long id) {
        greetingService.deleteGreeting(id);
    }
}