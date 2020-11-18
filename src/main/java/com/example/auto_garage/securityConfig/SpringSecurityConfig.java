package com.example.auto_garage.securityConfig;

import com.example.auto_garage.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
               // .antMatchers(HttpMethod.GET, "/**").hasAuthority("ADMIN")
                //.antMatchers(HttpMethod.GET, "/customers/id").hasRole("MONTEUR")
                //.antMatchers(HttpMethod.GET, "/invoice**").hasRole("MONTEUR")
                //.antMatchers(HttpMethod.GET, "/customers**").hasRole("FRONTDESK")
                //.antMatchers(HttpMethod.GET, "/invoice/id").hasRole("KASSIERE")
                //.antMatchers(HttpMethod.GET, "/part**").hasRole("STOCK_MW")
                //.antMatchers(HttpMethod.GET, "/reparings**").hasRole("STOCK_MW")
                .antMatchers(HttpMethod.GET,"/authenticated/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

}