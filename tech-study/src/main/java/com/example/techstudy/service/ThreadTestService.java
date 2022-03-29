package com.example.techstudy.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: 11411
 * @date: 2022/3/20 14:47
 */
@Service
public class ThreadTestService {

    @Resource
    private ConcreteThreadService threadService;

    public void test() {
        for (int i = 0; i < 10; i++) {
          threadService.run(i);
        }
    }


}
