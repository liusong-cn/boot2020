package com.bz.mapper;

import com.bz.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:11411
 * @date: 2020/8/10 17:05
 **/
@Mapper
public interface UserMapper {

    User findByUserName(String userName);
}
