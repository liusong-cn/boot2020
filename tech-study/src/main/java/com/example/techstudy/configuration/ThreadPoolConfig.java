package com.example.techstudy.configuration;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: 11411
 * @date: 2022/3/20 15:02
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("threadPoolExecutor")
    public ThreadPoolExecutor getThreadPoolExecutor(){
        int coreSize = Runtime.getRuntime().availableProcessors();
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("测试线程池-demo-%d").build();
        return  new ThreadPoolExecutor(coreSize,coreSize + 1,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>(60),threadFactory);
    }
}
