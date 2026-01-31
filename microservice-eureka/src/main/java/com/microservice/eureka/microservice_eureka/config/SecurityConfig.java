package com.microservice.eureka.microservice_eureka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                        // El dashboard de Eureka requiere autenticación
                        .requestMatchers("/").authenticated()

                        // Los endpoints de registro de servicios son públicos (o con autenticación básica)
                        .requestMatchers("/eureka/**").permitAll()  // O .authenticated()

                        // Actuator endpoints
                        .requestMatchers("/actuator/**").permitAll()

                        .anyRequest().authenticated()
                )
                // Autenticación básica para el dashboard
                .httpBasic(httpBasic -> {})
                .build();
    }
}