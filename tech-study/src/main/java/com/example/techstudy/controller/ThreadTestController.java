package com.example.techstudy.controller;

import com.example.techstudy.service.ThreadTestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author: 11411
 * @date: 2022/3/20 14:46
 */
@Controller
@RequestMapping("/thread")
public class ThreadTestController {

    @Resource
    private ThreadTestService testService;

    @GetMapping("/doSomething")
    public void doSomething(){
        testService.test();
    }
}
