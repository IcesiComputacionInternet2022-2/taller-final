package com.edu.icesi.MusicShop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("admin")
                .antMatchers("/anonymous*")
                .anonymous()
                .antMatchers("/rest/login*")
                .anonymous()
                .antMatchers(HttpMethod.POST, "/rest/item*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and();
        return http.build();
    }

}
