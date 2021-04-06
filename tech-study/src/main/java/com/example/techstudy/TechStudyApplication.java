package com.example.techstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.example.techstudy.mapper"})
@EnableTransactionManagement
public class TechStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechStudyApplication.class, args);
    }

}
