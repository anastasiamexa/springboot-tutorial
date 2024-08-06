package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.demo.common.Coach;
import com.springboot.demo.common.SwimCoach;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() { // the method name is the bean id
        return new SwimCoach();
    }
}
