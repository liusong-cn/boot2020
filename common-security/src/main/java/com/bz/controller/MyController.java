package com.bz.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:11411
 * @date: 2020/9/3 13:37
 **/
@RestController
public class MyController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/authenticate")
    @PreAuthorize("hasAnyAuthority('admin')")
    public String authenticated(){
        return "authenticated";
    }
}
