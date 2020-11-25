package com.bz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ls
 * @date: 2020/11/25 11:17
 **/
@RequestMapping("/activiti")
@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello(){
        return "hellogoo";
    }
}
