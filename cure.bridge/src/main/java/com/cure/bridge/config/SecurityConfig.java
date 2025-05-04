package com.cure.bridge.config;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.header.writers.StaticHeadersWriter;

//@Configuration
public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())  // Disable CSRF for WebSockets
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/**").permitAll()  // Allow WebSocket connections
//                        .anyRequest().authenticated()
//                )
//                .headers(headers -> headers
//                        .addHeaderWriter(new StaticHeadersWriter("Content-Security-Policy",
//                                "default-src 'self'; connect-src 'self' ws://localhost:8089 wss://localhost:8089")
//                        )
//                )
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return http.build();
//    }
}