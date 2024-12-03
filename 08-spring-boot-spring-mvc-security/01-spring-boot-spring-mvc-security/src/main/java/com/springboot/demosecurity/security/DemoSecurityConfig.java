package com.springboot.demosecurity.security;

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
                .password("{noop}12345")
                .roles("EMPLOYEE")
                .build();

        UserDetails janet = User.builder()
                .username("janet")
                .password("{noop}12345")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails stacy = User.builder()
                .username("stacy")
                .password("{noop}12345")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(michael, janet, stacy);
    }
}
