package com.bz.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author:11411
 * @date: 2020/8/17 9:06
 **/
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public static <T>  T getBean(Class<T> clazz){
        return context.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> requiredType){
        return context.getBean(name, requiredType);
    }

    public static boolean constainsBean(String name){
        return context.containsBean(name);
    }

    public static boolean singelton(String name){
        return context.isSingleton(name);
    }

    public static Class<?> getType(String name){
        return context.getType(name);
    }


}
