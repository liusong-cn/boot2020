package com.bz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义全局异常处理
 * @author:ls
 * @date: 2020/9/15 15:58
 **/
@RestController
public class FallbackController {

    @RequestMapping("/fallbackController")
    public Map<String, String> fallback(){
        Map<String, String> fallback = new HashMap<>();
        fallback.put("code","-100");
        fallback.put("msg","service not available");
        return fallback;
    }
}
