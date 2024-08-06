package com.springboot.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.common.Coach;

@RestController
public class DemoController {

    // Define a private field for the dependency
    private Coach coach;
    private Coach coach2;

    // Define a setter injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach coach,
            @Qualifier("cricketCoach") Coach coach2) {
        System.out.println("In constructor of " + this.getClass().getName());
        this.coach = coach;
        this.coach2 = coach2;
    }

    // Define a method to expose a REST endpoint
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: coach == coach2, " + (coach == coach2);
    }
}
