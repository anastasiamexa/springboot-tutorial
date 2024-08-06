package com.springboot.demo.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor of " + this.getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }
}
