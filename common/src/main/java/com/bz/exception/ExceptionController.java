package com.bz.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author:11411
 * @date: 2020/8/20 15:27
 **/
@ControllerAdvice
public class ExceptionController {

    //定义权限不足的excetion处理，跳转403页面
    @ExceptionHandler(value = AuthorizationException.class)
    public String unauthz(){
        return "403";
    }
}
