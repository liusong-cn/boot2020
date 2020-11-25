package com.bz.controller;

import com.bz.entity.Role;
import com.bz.entity.User;
import com.bz.service.RoleServiceI;
import com.bz.service.UserServiceI;
import com.bz.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:11411
 * @date: 2020/7/23 10:10
 **/
@RestController
@Api(tags = "测试")
public class MyController {

    private static final Logger log = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private UserServiceI userService;

    @Autowired
    private RoleServiceI roleService;

    @ApiOperation(value = "测试方法")
    @GetMapping(value = "/hello")
    public String hello(){
        log.info("进入系统日志");
        return "hello";
    }

    @PostMapping(value = "/userAdd")
    @ApiOperation(value = "测试mybatis配置")
    public String addUser(@RequestBody User user){
        int r = userService.insertUser(user);
        return r + "";
    }

    @GetMapping(value = "/userQuery")
    @ApiOperation(value = "测试mybatis查询")
    public String queryUser(@RequestParam String name){
        User u = userService.selectUserByName(name);

        return u.getName();
    }

    @PostMapping(value = "/roleAdd")
    @ApiOperation(value = "测试新增角色")
    public String addRole(Role role){
        int r = roleService.insertRole(role);
        return r + "";
    }

    @ApiOperation(value = "测试自定义的vo")
    @GetMapping(value = "/userSelect")
    public String query(){
        UserVO vo = userService.selectUser();
        return vo.getName();
    }
}
