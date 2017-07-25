package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        /**定义那些URL需要被饱，那些不需要被保护*/
        http.authorizeRequests()
                /**"/"与"/home"不需要被认证就可以访问*/
                .antMatchers("/", "/home").permitAll()
                /**其他的路劲都必须通过身份验证*/
                .anyRequest().authenticated()
                .and()
                 /**定义当用户登录的时候转到的登录页面*/
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws  Exception
    {
        authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password("password").roles("USER");
    }
}
