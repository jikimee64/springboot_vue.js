package com.springboot.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**",
                "/images/**", "/css/**", "/img/**", "/js/**",
                "/console/**", "/favicon.ico/**", "/assets/**",
                "/dist/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();		// 개발 시 에만

        http.authorizeRequests().antMatchers("/", "/js/**", "/css/**", "/fonts/**", "/user/signup", "/api/**").permitAll() /*로그인 없이 접속 할 수 있는 위치*/.anyRequest().authenticated();
        http.formLogin().loginPage("/login").defaultSuccessUrl("/").usernameParameter("id")
                .passwordParameter("password").permitAll().and().logout().permitAll();
    }
}

