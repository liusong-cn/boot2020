package com.bz;

import com.bz.domain.SysUser;
import com.bz.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author:ls
 * @date: 2020/9/16 16:41
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserTest {

    @Autowired
    private SysUserMapper userMapper;

    @Test
    public void insertUser(){
        SysUser user = new SysUser();
        user.setUserName("李四");
        user.setLoginName("lisi");
        user.setDeptId(1L);
        user.setPassword("abc");
        int r = userMapper.insertUser(user);
    }

}
