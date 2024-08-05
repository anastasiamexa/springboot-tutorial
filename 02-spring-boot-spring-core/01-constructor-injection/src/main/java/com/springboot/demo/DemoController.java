package com.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for the dependency
    private Coach coach;

    // Define a constructor for dependency injection
    @Autowired
    public DemoController(Coach theCoach) {
        coach = theCoach;
    }

    // Define a method to expose a REST endpoint
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
