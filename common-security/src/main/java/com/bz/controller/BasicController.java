package com.bz.controller;

import com.bz.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author:11411
 * @date: 2020/9/4 9:34
 **/
@Controller
public class BasicController {

    @Autowired
    private RedisService redisService;


    @GetMapping("/index")
    public String index(){
        System.out.println(123);
        return "index";
    }
}
