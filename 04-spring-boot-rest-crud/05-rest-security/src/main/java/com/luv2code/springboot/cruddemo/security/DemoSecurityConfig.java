package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    // Add support for JDBC authentication
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // Define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
            "select user_id, pw, active from members where user_id = ?"
        );

        // Define query to retrieve roles for a user by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
            "select user_id, role from roles where user_id = ?"
        );
        
        return jdbcUserDetailsManager;
    }
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
            .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
            .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
            .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
            .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
            .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // Use httpBasic authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    /*@Bean
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
    }*/
}
