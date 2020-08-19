package com.bz.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:11411
 * @date: 2020/8/19 15:39
 **/
@ControllerAdvice(annotations = Controller.class)
public class ExceptionController {

    @ExceptionHandler(value = UnauthorizedException.class)
    public String defaultErrorHander(HttpServletRequest req, Exception e){
        return "/403";
    }
}
