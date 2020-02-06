//IntelliJ IDEA
//ch5_2_3
//WebSecurityConfig
//2020/2/6
// Author:御承扬
//E-mail:2923616405@qq.com

package com.wisely.ch5_2_3;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/login", "/ws").permitAll()  //根路径和/login、/ws不拦截
        .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")    //登陆页面
        .defaultSuccessUrl("/chat") //登录成功转向该页面
        .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("pyc").password("pyc").roles("USER")
                .and()
                .withUser("ycy").password("ycy").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("src/main/resources/static/**"); //静态资源放行
    }
}
