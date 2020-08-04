package com.bz.mapper;

import com.bz.entity.User;
import com.bz.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:11411
 * @date: 2020/7/24 9:27
 **/
@Mapper
public interface UserMapper {

    int insertUser(User user);

    User selectUserByName(String name);

    /**
     * 测试mapper中映射实体的关系
     */
    UserVO selectUser();
}
