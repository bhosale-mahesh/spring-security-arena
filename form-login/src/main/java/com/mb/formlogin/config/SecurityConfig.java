package com.mb.formlogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                .httpBasic(withDefaults()) // Authorization: Basic ... header is used, in curl or API
                .formLogin(withDefaults()) // Use form in browser
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()
                        .authenticated()
                );
        return http.build();
    }
}
