package com.bz.mapper;

import com.bz.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:ls
 * @date: 2020/9/17 9:14
 **/
@Mapper
public interface SysRoleMapper {

    int insertRole(SysRole role);
}
