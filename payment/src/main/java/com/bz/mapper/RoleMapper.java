package com.bz.mapper;

import com.bz.entity.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:11411
 * @date: 2020/7/24 16:22
 **/
@Mapper
public interface RoleMapper {

    int insertRole(Role role);
}
