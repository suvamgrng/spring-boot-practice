package com.suvam.springtokenpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
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
                .formLogin(form -> form
                        .defaultSuccessUrl("/")
                )
                .logout(log -> log
                        .logoutSuccessUrl("/logout?logout")
                        .permitAll()
                );
        return http.build();
    }
}
