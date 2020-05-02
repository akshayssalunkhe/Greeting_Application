package com.greetingapp.controller;

import com.greetingapp.dto.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello %s!";

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
}