package com.bz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author:11411
 * @date: 2020/9/4 9:34
 **/
@Controller
public class BasicController {

    @GetMapping("/index")
    public String index(){
        System.out.println(123);
        return "index";
    }
}
