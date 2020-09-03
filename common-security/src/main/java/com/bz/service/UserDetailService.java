package com.bz.service;

import com.bz.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author:11411
 * @date: 2020/9/3 14:05
 **/
@Configuration
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     *  提供包装user信息的对象，供security进行调用，用户密码的校验交由security执行
     * @param s username
     * @return user信息包装对象
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //此处直接提供用户信息，常规应该由数据库提供
        MyUser user  = new MyUser();
        user.setUserName(s);
        user.setPassword(passwordEncoder.encode("123"));
        return new User(user.getUserName(),user.getPassword(),user.isEnabled(),user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),user.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
