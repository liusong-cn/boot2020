package com.bz.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**结合gateway测试gateway相关能力
 * @author:ls
 * @date: 2020/9/15 15:27
 **/
@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @GetMapping("/addRequestHeader")
    public String addRequestHeader(HttpServletRequest request){
        String color = request.getHeader("X-Request-red");
        return "color is :" + color;
    }

    @GetMapping("/addRequestParameter")
    public String addRequestParameter(HttpServletRequest request){
        return "parameter value is :" + request.getParameter("red");
    }

}
