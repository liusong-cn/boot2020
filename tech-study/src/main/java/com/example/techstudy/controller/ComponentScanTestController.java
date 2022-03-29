package com.example.techstudy.controller;

import com.bz.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 11411
 * @date: 2022/3/29 22:01
 */
@RestController
public class ComponentScanTestController {

    @Autowired
    private MyService myService;

    @GetMapping("/test-scan")
    public void testScan(){
        myService.run();
    }
}
