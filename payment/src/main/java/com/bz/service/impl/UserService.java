package com.bz.service.impl;

import com.bz.entity.User;
import com.bz.mapper.UserMapper;
import com.bz.service.UserServiceI;
import com.bz.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author:11411
 * @date: 2020/7/24 9:29
 **/
@Service
public class UserService implements UserServiceI {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        int row = userMapper.insertUser(user);
        System.out.println(111);
        return 0;
    }

    @Override
    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public UserVO selectUser() {
        userMapper.selectUser();
        return userMapper.selectUser();
    }


}
