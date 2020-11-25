package com.bz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author:11411
 * @date: 2020/9/4 15:31
 **/
@Configuration
@EnableResourceServer
@Order(6)
public class ResourceConfig extends ResourceServerConfigurerAdapter {
        //可自定义鉴权匹配
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login","/logout","/hello")
                .permitAll()//可放权特定资源，authorization_code模式需要自定义登录过程，即/login相关，后续研究
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();//其余资源需鉴权
    }
}
