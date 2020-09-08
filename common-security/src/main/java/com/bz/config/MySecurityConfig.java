package com.bz.config;

import com.bz.handler.AuthenticationAccessDeniedHandler;
import com.sun.org.apache.xpath.internal.operations.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author:11411
 * @date: 2020/9/3 13:41
 **/
@Configuration
//开启方法中使用注解进行权限控制
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    //自定义权限不足handler
    @Autowired
    private AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单登录
//        http.formLogin()
//                .and()
//                .authorizeRequests()//授权配置
//                .anyRequest()//所有请求
//                .authenticated()//需要鉴权
//                .and()
//                .exceptionHandling()//添加自定义的鉴权失败handler
//                .accessDeniedHandler(authenticationAccessDeniedHandler);

//        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/hello","/login")
                .permitAll()//放权特定url
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()//任意请求都需要鉴权
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //认证管理器
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
