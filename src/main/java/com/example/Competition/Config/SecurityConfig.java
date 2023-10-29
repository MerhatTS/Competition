package com.example.Competition.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(authorization -> {
            authorization.requestMatchers("/profile").hasRole("user");
            authorization.requestMatchers("/admin").hasRole("admin");
            authorization.anyRequest().permitAll();
        });
        httpSecurity.formLogin((Customizer.withDefaults()));
        return httpSecurity.build();
    }
}
