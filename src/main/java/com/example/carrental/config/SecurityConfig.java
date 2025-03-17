package com.example.carrental.config;

// package com.example.carrental.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for testing
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/**").permitAll() // Allow all requests to user endpoints
                .anyRequest().authenticated()
            )
            .formLogin(login -> login.disable()) // Disable login form
            .httpBasic(basic -> basic.disable()); // Disable basic auth
        return http.build();
    }
}
