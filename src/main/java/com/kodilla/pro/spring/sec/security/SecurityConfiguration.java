package com.kodilla.pro.spring.sec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("u1").password("u1").roles("R1");
        auth.inMemoryAuthentication().withUser("u2").password("u2").roles("R2");
        auth.inMemoryAuthentication().withUser("u3").password("u3").roles("R3");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/m1").hasAnyRole("R1", "R2", "R3")
                .mvcMatchers(HttpMethod.GET, "/m2").hasAnyRole("R2", "R3")
                .mvcMatchers(HttpMethod.GET, "/m3").hasAnyRole("R3")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();
    }
}
