package com.example.techstudy.controller;

import com.example.techstudy.service.ThreadTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: 11411
 * @date: 2022/3/20 14:46
 */
@RestController
@RequestMapping("/thread")
public class ThreadTestController {

    @Resource
    private ThreadTestService testService;

    @GetMapping("/doSomething")
    public void doSomething(){
        testService.test();
    }
}
