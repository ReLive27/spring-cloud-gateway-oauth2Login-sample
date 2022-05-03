package com.relive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/resource/**")
                .and()
                .authorizeRequests()
                .mvcMatchers("/resource/**")
                .access("hasAuthority('SCOPE_profile')")
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
}
