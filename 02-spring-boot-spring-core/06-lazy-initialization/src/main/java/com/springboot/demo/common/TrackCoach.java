package com.springboot.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("In constructor of " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
