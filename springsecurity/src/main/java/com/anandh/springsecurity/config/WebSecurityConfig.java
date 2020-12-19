package com.anandh.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   /* @Autowired
    DataSource dataSource;*/

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Without DB memory authentication
        *//*auth.inMemoryAuthentication()
                .withUser("Anandh").password(passwordEncoder().encode("Java")).roles("USER").
                and()
                .withUser("Bro").password(passwordEncoder().encode("Micro")).roles("ADMIN");
*//*
        //With default schema with H2Data
        *//*auth.jdbcAuthentication().dataSource(dataSource)
                .withDefaultSchema().withUser(User.withUsername("mohan").password(passwordEncoder().encode("bro")).roles("EMP"))
                .withUser("arun").password("bro").roles("ADMIN");*//*
        auth.jdbcAuthentication().dataSource(dataSource);

    }*/

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailService);


    }

// for own defined schema .

  /*  @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select email,password,enabled "
                        + "from bael_users "
                        + "where email = ?")
                .authoritiesByUsernameQuery("select email,authority "
                        + "from authorities "
                        + "where email = ?");
    }*/


    @Bean
    public PasswordEncoder encodePwd() {
        return NoOpPasswordEncoder.getInstance();
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/


    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/bro").hasAnyAuthority("ADMIN")
                .antMatchers("/nanban").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/natpu").hasAnyRole("ADMIN", "USER")

                .antMatchers("/employee/admin").hasAnyAuthority("ADMIN")
                .antMatchers("/employee/user").hasAnyAuthority("ADMIN", "EMP")
                .antMatchers("/employee/address").hasAnyAuthority( "EMP")
                .antMatchers("/").permitAll().
                and().formLogin();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user/admin").hasRole("ADMIN")
                .antMatchers("/home/name").hasAnyRole("USER", "ADMIN")
                .antMatchers("/home/user").hasAnyRole("USER", "ADMIN")

                .antMatchers("/employee/admin").hasRole("ADMIN")
                .antMatchers("/employee/user").hasAnyRole("EMP", "ADMIN")
                .antMatchers("/employee/address").hasAnyRole("EMP", "ADMIN")
                .antMatchers("/**").permitAll().
                and().formLogin();
    }

}
