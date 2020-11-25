package com.bz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author:11411
 * @date: 2020/7/22 15:48
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RestController
    public class TestController{
        private final RestTemplate restTemplate;

        @Autowired
        public TestController(RestTemplate restTemplate){
            this.restTemplate = restTemplate;
        }

        @GetMapping(value = "/echo/{str}")
        public String echo(@PathVariable String str){
            //配置provider服务的服务地址
            return restTemplate.getForObject("http://order9003/echo/"+str,String.class);
        }
    }
}
