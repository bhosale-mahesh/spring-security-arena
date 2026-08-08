package com.mb.formlogin.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .httpBasic(withDefaults()) // Authorization: Basic ... header is used, in curl or API
                .formLogin(withDefaults()); // Use form in browser

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(User.withUsername("mahesh")
                .password("{bcrypt}$2a$12$0L5igF4Hvqj4YX3sWoAfiO2hAzkakCzb63hVlwDMr4LXACp4G4FZO")
                .build());
    }
}
