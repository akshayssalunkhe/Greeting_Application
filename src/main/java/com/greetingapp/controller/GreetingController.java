package com.greetingapp.controller;

import com.greetingapp.dto.Greeting;
import com.greetingapp.dto.User;
import com.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello %s!";

    @Autowired
    IGreetingService greetingService;

    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public Greeting sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/param/{name}")
    public Greeting sayHelloParam(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(name));
    }

    @RequestMapping("/greetingService")
    public String greeting() {
        return greetingService.getGreeting();
    }

    @PutMapping("/put/{firstName}")
    public Greeting greetingPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(firstName, lastName));
    }

    @PostMapping("/post")
    public Greeting greetingPost(@RequestBody User user) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(user.getFirstName(), user.getLastName()));
    }
}