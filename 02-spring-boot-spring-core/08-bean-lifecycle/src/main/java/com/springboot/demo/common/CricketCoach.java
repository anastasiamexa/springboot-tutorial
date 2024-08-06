package com.springboot.demo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor of " + this.getClass().getName());
    }

    // Define init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("CricketCoach: inside method doMyStartupStuff");
    }

    // Define destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("CricketCoach: inside method doMyCleanupStuff");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
