package com.example.redditApi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

//this is an analog for xml file. it will be use to configure our application with security features
@Configuration
//allows Spring to find configuration class and automatically apply the class to the global WebSecurity.
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //in memory authentication: we hardcode the username and password in the code itself
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(users.username("test").password("test").roles("ADMIN"));
    }
    //this method configures out requests
    //This method ensures that all requests are authenticated with Http based authentication.

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .and()
                .httpBasic();
    }


}
