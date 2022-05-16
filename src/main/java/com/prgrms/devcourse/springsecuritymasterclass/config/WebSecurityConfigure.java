package com.prgrms.devcourse.springsecuritymasterclass.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override // WebSecurity 클래스는 필터 체인 관련 전역 설정을 처리할 수 있는 API 제공
    public void configure(WebSecurity web)  {
        web.ignoring().antMatchers("/assets/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/me")
                .hasAnyRole("USER", "ADMIN")
                .anyRequest().
                permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/")
                .permitAll().and();
    }
}