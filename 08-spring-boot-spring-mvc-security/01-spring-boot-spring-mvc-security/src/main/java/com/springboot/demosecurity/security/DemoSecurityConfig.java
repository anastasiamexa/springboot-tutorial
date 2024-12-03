package com.springboot.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/showMyLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll() // Allow everyone to see login page. No need to be logged in.
                )
                .logout(logout -> logout.permitAll()); // Redirect to login page after logout by default.

        return http.build();
    }
}
