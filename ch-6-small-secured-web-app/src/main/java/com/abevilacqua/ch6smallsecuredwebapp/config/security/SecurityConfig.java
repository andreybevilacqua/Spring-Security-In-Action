package com.abevilacqua.ch6smallsecuredwebapp.config.security;

import com.abevilacqua.ch6smallsecuredwebapp.service.AuthenticationProviderService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationProviderService authenticationProviderService;

    public SecurityConfig(AuthenticationProviderService authenticationProviderService) {
        this.authenticationProviderService = authenticationProviderService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProviderService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .defaultSuccessUrl("/main", true);

        http.authorizeRequests()
            .anyRequest().authenticated();
    }
}
