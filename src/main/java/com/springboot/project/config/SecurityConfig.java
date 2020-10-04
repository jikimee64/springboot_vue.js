package com.springboot.project.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    // authenticationManager를 Bean 등록합니다.
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

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
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 토큰 기반 인증이므로 세션 역시 사용하지 않습니다.

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                //.rolePrefix("ROLE_")
                //앞에 ROLE_을 붙여야 home.html에서 정상적으로 hasRole()구문을 인식
                .usersByUsernameQuery("select id, password, enabled from user where id=?")
                .authoritiesByUsernameQuery("select id, authority from authorities where id=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

