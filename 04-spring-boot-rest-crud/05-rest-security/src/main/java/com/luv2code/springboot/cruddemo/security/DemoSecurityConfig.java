package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails michael = User.builder()
            .username("michael")
            .password("{noop}employee")
            .roles("EMPLOYEE")
            .build();

        UserDetails janet = User.builder()
            .username("janet")
            .password("{noop}employee")
            .roles("EMPLOYEE", "MANAGER")
            .build();

        UserDetails stacy = User.builder()
            .username("stacy")
            .password("{noop}employee")
            .roles("EMPLOYEE", "MANAGER", "ADMIN")
            .build();

        return new InMemoryUserDetailsManager(michael, janet, stacy);
    }
}
