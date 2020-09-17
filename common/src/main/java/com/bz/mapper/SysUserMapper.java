package com.bz.mapper;

import com.bz.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:ls
 * @date: 2020/9/16 16:20
 **/
@Mapper
public interface SysUserMapper {
    int insertUser(SysUser user);
}
