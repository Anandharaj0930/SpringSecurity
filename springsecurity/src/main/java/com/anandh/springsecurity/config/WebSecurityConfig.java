package com.anandh.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Without DB memory authentication
        //With hard code user and Pwd
        auth.inMemoryAuthentication()
                .withUser("Muthu").password("Java").roles("ADMIN").
                and()
                .withUser("Mohan").password("Micro").roles("USER");

    }


    @Bean
    public PasswordEncoder encodePwd() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/bro").hasAnyRole("ADMIN")
                .antMatchers("/nanban").hasAnyRole("USER", "ADMIN")
                .antMatchers("/natpu").hasRole("ADMIN")
                .antMatchers("/**").permitAll().
                and().formLogin();
    }

}
