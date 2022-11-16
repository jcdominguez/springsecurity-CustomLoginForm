package com.example.demosecuritycustomloginpage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf().disable()

            // URL autorizations:
            .authorizeRequests()
                // The order of the rules matters and the more specific rules should go first.
                // ne pas oublier le / devant les URLs
                .antMatchers("/", "/index.html", "/login*").permitAll()
                .anyRequest().authenticated()

            .and().formLogin()
                .loginPage("/mylogin").permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/hello", true)
                //.and().logout().permitAll()
                //.failureUrl("/login.html?error=true")
        ;
        return http.build();
    }
}
