package com.bz.config;

import com.bz.handler.AuthenticationAccessDeniedHandler;
import com.sun.org.apache.xpath.internal.operations.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

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
        http.formLogin()
                .and()
                .authorizeRequests()//授权配置
                .anyRequest()//所有请求
                .authenticated()//需要鉴权
                .and()
                .exceptionHandling()//添加自定义的鉴权失败handler
                .accessDeniedHandler(authenticationAccessDeniedHandler);

        //测试放权所有
//        http.requestMatchers()
//                .antMatchers("/**");

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
