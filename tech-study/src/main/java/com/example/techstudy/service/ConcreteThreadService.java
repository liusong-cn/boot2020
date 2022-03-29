package com.example.techstudy.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: 11411
 * @date: 2022/3/20 15:22
 */
@Service
public class ConcreteThreadService {

    @Async("threadPoolExecutor")
    public void run(int i) {

        System.out.println(Thread.currentThread().getName() + ":" + i);
    }
}
