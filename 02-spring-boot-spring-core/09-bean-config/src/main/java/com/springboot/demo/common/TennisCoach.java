package com.springboot.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println("In constructor of " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
