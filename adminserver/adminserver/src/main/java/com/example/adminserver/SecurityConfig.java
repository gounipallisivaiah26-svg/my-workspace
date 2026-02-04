package com.example.adminserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/", 
                    "/assets/**",
                    "/webjars/**",
                    "/favicon.ico",
                    "/error",
                    "/actuator/**",
                    "/instances/**",
                    "/applications/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

        // allow clients to register with the admin server (ignore CSRF for instances endpoints)
        http.csrf(csrf -> csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/instances/**")));

        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        // simple in-memory user for testing. Password is stored in plain text using {noop} prefix.
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password("{noop}admin").roles("ADMIN").build());
        return manager;
    }
}