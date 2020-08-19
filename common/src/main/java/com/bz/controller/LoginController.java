package com.bz.controller;

import com.bz.config.JWTUtil;
import com.bz.entity.ResponseBo;
import com.bz.entity.User;
import com.bz.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:11411
 * @date: 2020/8/11 10:10
 **/
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String username, String password){
        //暂未考虑密码加密
//        password = MD5Utils.encrypt(userName,password);
        //假定登录校验
        if(username.equals("liusong") && password.equals("123")){
            String token = JWTUtil.sign(username,password);
            return ResponseBo.ok().put("token",token);
        }else {
            return ResponseBo.error("用户名或密码错误");
        }
    }

    @RequestMapping("/")
    public String redirectIndex(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model){
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("token",token);
        return "index";
    }

    @RequestMapping("/403")
    public String unauth(){
        return "403";
    }

    @RequestMapping("/permission")
    @RequiresRoles("admin")
    @RequiresPermissions({"system:user:permission"})
    public String permissionTest(){
        return "permission";
    }
}
