package com.arrisdev.productservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**developed by
 * arris manduma
 * on 10/6/2021
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //initialize security key variable
    //@Value("${service.security.secure-key-username")
   // private String SECURE_KEY_USERNAME;

    //@Value("${service.security.secure-key-password")
    //private String SECURE_KEY_PASSWORD;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //passing username and password of the user
        auth.inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("user1Pass"))
                .roles("USER");
    }
    //setting restrictions to different paths to access the resource

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //first authorize all requests by disabling csrf
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
