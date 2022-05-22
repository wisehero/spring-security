package com.prgrms.devcourse.springsecuritymasterclass.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final DataSource dataSource;

    public WebSecurityConfigure(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override // WebSecurity 클래스는 필터 체인 관련 전역 설정을 처리할 수 있는 API 제공
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/assets/**", "/h2-console/**");
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
                .permitAll().and()
                .rememberMe().rememberMeParameter("remember-me")
                .tokenValiditySeconds(300)
                .and()
                .logout()// 로그아웃 설정
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))// logout()의 디폴트
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)// logout()의 디폴트
                .clearAuthentication(true)// logout()의 디폴트
                .and() // HTTP 요청을 HTTPS 요청으로 리다이렉트
                .requiresChannel()
                .anyRequest().requiresSecure();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user123").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin123").roles("ADMIN");
    }
}