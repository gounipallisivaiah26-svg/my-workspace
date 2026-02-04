package com.APIGateWay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class GatewaySecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // Disable CSRF (API gateway typically forwards stateless requests)
        // Allow the user routes so POST/PUT won't be blocked by missing CSRF token
        http
            .csrf(csrf -> csrf.disable())
            .authorizeExchange(ex -> ex
                .pathMatchers("/users1/**", "/users2/**").permitAll()
                // you can lock down other endpoints if needed
                .anyExchange().permitAll()
            );

        return http.build();
    }
}
