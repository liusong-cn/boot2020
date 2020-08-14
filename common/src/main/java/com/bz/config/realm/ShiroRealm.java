package com.bz.config.realm;

import com.bz.entity.User;
import com.bz.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author:11411
 * @date: 2020/8/10 16:43
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //用户鉴权
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
        String userName = uptoken.getUsername();
        String password = new String(uptoken.getPassword());
        User user = userMapper.findByUserName(userName);

        if(userName == null){
            throw new UnknownAccountException("用户名或密码错误");
        }
        if(!password.equals(user.getPassword())){
            throw new IncorrectCredentialsException("用户名或密码错误");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
