package com.easyLearing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class EurekaSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // disable CSRF for Eureka endpoints
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // allow Eureka clients and actuator endpoints to register without auth
                .requestMatchers("/eureka/**", "/actuator/**", "/", "/error", "/favicon.ico").permitAll()
                .anyRequest().authenticated()
            )
            // keep basic auth for other endpoints if needed
            .httpBasic();

        return http.build();
    }
}
