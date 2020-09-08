package com.bz.controller;

import com.bz.SecurityApplication;
import com.bz.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author:11411
 * @date: 2020/9/8 16:52
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SecurityApplication.class)
public class BasicControllerTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void set(){
       boolean result =  redisService.set("age",28);
        System.out.println(result);
    }

    @Test
    public void get(){
        int age = (int) redisService.get("age");
        System.out.println(age);
    }
}
