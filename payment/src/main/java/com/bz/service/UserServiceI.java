package com.bz.service;

import com.bz.entity.User;
import com.bz.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:11411
 * @date: 2020/7/24 9:28
 **/
public interface UserServiceI {

    int insertUser(User user);

    User selectUserByName(String name);

    UserVO selectUser();
}
