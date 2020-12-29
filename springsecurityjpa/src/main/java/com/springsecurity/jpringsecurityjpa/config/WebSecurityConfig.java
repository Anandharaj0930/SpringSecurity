package com.springsecurity.jpringsecurityjpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;



   /* @Bean
    public PasswordEncoder encodePwd() {
        return NoOpPasswordEncoder.getInstance();
    }*/


    //With JPA

    @Autowired
    @Qualifier("userDetailsService")
    MyUserDetailService userDetailService;

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
                .antMatchers("/user/admin", "/employee/admin").hasRole("ADMIN")
                .antMatchers("/dept/depart").hasAnyRole("USER", "ADMIN")
                .antMatchers("/dept/store").hasAnyRole("USER", "ADMIN")

                .antMatchers("/employee/user").hasAnyRole("EMP", "ADMIN")
                .antMatchers("/employee/address").hasAnyRole("EMP", "ADMIN")
                .antMatchers("/**").permitAll().
                and().formLogin();
    }

}
