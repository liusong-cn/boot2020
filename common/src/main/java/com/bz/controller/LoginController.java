package com.bz.controller;

import com.bz.entity.ResponseBo;
import com.bz.entity.User;
import com.bz.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
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
//        password = MD5Utils.encrypt(userName,password);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return ResponseBo.ok();
        }catch (UnknownAccountException e){
            return ResponseBo.error(e.getMessage());
        }catch (IncorrectCredentialsException e){
            return ResponseBo.error(e.getMessage());
        }catch (LockedAccountException e){
            return ResponseBo.error(e.getMessage());
        }catch (AuthenticationException e){
            return ResponseBo.error("认证失败");
        }
    }

    @RequestMapping("/")
    public String redirectIndex(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user",user);
        return "index";
    }
}
