package com.bz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:11411
 * @date: 2020/7/29 9:34
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    @RestController
    public class EchoController{

        @GetMapping(value = "/echo/{string}")
        public String echo(@PathVariable String string){
            return "hello Nacos Discovery " + string;
        }

        @GetMapping("/getNacosConfig/{param}")
        public String getNacosConfig(HttpServletRequest request,@PathVariable String param){
            return null;
        }
    }
}
