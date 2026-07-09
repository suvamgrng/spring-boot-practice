package com.suvam.springtokenpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class OfficerConfig {

    @Bean
    public SecurityFilterChain addSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/officer",
                                "/get-token",
                                "/"
                        )
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/officer", true)
                        .permitAll()
                )
                .logout(log -> log
                        .logoutSuccessUrl("/logout?logout")
                        .permitAll()
                );
        return http.build();
    }
}
