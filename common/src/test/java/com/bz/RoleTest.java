package com.bz;

import com.bz.domain.SysRole;
import com.bz.mapper.SysRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author:ls
 * @date: 2020/9/17 9:27
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class RoleTest {

    @Resource
    private SysRoleMapper roleMapper;

    @Test
    public void testInsert(){
        SysRole role = new SysRole();
        role.setRoleName("管理员");
        role.setRoleKey("manager");
        role.setCreateBy("liusong");
        role.setCreateTime(new Date());
//        role.setUpdateTime(new Date());
        int r = roleMapper.insertRole(role);
    }
}
