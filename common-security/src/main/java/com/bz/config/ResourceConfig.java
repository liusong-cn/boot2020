package com.bz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author:11411
 * @date: 2020/9/4 15:31
 **/
@Configuration
@EnableResourceServer
@Order(6)
public class ResourceConfig {
}
