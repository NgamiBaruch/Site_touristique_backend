package com.example.tedon.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig{

    @Autowired
    private JwtAuthFilter authFilter;

    // PasswordEncoder bean - BCrypt haute sécurité (recommandé)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager - utilisé par le controller pour l'authentification
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    // chaîne de sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // on désactive les sessions => stateless
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // endpoints publics pour s'enregistrer / login /Swagger
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/api/user/change-password",
                                "/api/user/login",
                                "/api/user/**",
                                "/swagger-resources").permitAll()
                        // accès lecture services pour tous authentifiés et non-authentifiés (si voulu) :
                        .requestMatchers("/api/services").permitAll()
                        // endpoints réservés aux admins
                        .requestMatchers("/api/administrateur/").hasAuthority("ROLE_ADMINISTRATEUR")
                        .requestMatchers("/api/administrateur/**").hasAuthority("ROLE_ADMINISTRATEUR")
                        .requestMatchers("/api/agent/").hasAuthority("ROLE_AGENT")
                        .requestMatchers("/api/client/").hasAuthority("ROLE_CLIENT")
                        //.requestMatchers("/api/service/").permitAll()
                        // endpoints admin pour creation/modification/suppression des services
                        // on protège via @PreAuthorize dans controller aussi
                        .anyRequest().authenticated()
                );

        // ajouter le filtre JWT avant UsernamePasswordAuthenticationFilter
        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }




}







