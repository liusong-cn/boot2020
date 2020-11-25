package com.bz.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:11411
 * @date: 2020/7/29 10:15
 **/
@RestController
@RequestMapping(value = "/config")
@RefreshScope
public class ConfigController {

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @Value("${isOk:false}")
    private String isOk;

    @Value("${user.name:zhangsan}")
    private String user;

    @GetMapping(value = "/get")
    public boolean get(){
        return useLocalCache;
    }

    @GetMapping("/get1")
    public String get1(){
        return user;
    }

    @GetMapping("/get2")
    public String get2(){
        return isOk;
    }
}
