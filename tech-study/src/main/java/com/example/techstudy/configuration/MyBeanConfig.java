package com.example.techstudy.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 11411
 * @date: 2022/3/29 22:38
 * 通过此配置尝试将其他jar中component注入到该module
 */
@Configuration
// 1.使用scan时，不能配置通配符，会冲掉所有非通配符的配置
// 2.不能配置在主类上，否则冲掉默认配置
// * 指定包 ** 任意包和类
@ComponentScan({"com.bz.service"})
public class MyBeanConfig {
}
