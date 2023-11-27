package com.example.Competition.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authorization -> {
            authorization.requestMatchers("/profile").hasRole("user");
            authorization.requestMatchers("/admin/listPlayers").hasRole("admin");
            authorization.requestMatchers("/admin/addTeams").hasRole("admin");
            authorization.requestMatchers("/admin/adminTeams").hasRole("admin");
            authorization.requestMatchers("/admin/addSchedule").hasRole("admin");
            authorization.requestMatchers("/admin/addPlayers/{id}").hasRole("admin");
            authorization.anyRequest().permitAll();
        });
        httpSecurity.formLogin((Customizer.withDefaults()));
        return httpSecurity.build();
    }
}
