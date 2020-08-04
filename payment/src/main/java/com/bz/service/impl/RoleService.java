package com.bz.service.impl;

import com.bz.entity.Role;
import com.bz.mapper.RoleMapper;
import com.bz.service.RoleServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author:11411
 * @date: 2020/7/24 16:34
 **/
@Service
public class RoleService implements RoleServiceI {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public int insertRole(Role role) {
        int row = roleMapper.insertRole(role);
        return row;
    }
}
