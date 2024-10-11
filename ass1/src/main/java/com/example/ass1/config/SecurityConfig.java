package com.example.ass1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for testing purposes
                .authorizeHttpRequests() // Use authorizeHttpRequests()
                .requestMatchers("/api/signup", "/api/login", "/api/logout", "/api/user-details", "/api/user-details/update/**").permitAll()
                .anyRequest().authenticated() // All other requests need authentication
                .and()
                .formLogin().disable(); // Disable form login

        return http.build();
    }
}
