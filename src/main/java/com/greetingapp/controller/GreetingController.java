package com.greetingapp.controller;

import com.greetingapp.dto.Greeting;
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

    @PutMapping("/put/{firstName}")
    public Greeting greetingPathVariableAndRequestParam(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        String template = "Hello , %s %s !";
        return new Greeting(counter.incrementAndGet(), String.format(template, firstName, lastName));
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greetingService")
    public String greeting() {
        return greetingService.getGreeting();
    }

    @GetMapping("/greetingServiceFirstName/param/{firstName}")
    public String greetingWithFirstName(@PathVariable String firstName) {
        return greetingService.getGreetingWithFirstName(firstName);
    }

    @GetMapping("/greetingServiceLastName/param/{lastName}")
    public String greetingWithLastName(@PathVariable String lastName) {
        return greetingService.getGreetingWithLastName(lastName);
    }

    @GetMapping("/greetingServiceFullName/param/{fullName}")
    public String greetingWithFullName(@PathVariable String fullName) {
        return greetingService.getGreetingWithFullName(fullName);
    }
}