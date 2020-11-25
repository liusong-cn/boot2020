package com.bz.config.realm;

import com.bz.config.JWTUtil;
import com.bz.entity.User;
import com.bz.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author:11411
 * @date: 2020/8/10 16:43
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //这一步目的在于获得用户的角色信息
        user = userMapper.findByUserName(user.getName());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roleNames = new HashSet<>();
        user.getRoles().stream().forEach(role -> roleNames.add(role.getRoleName()));
        simpleAuthorizationInfo.setRoles(roleNames);
        //假定一些权限 system:user:view,system:user:update
        Set<String> perms = new HashSet<>();
        perms.add("system:user:view");
        perms.add("system:user:update");
        simpleAuthorizationInfo.setStringPermissions(perms);
        return simpleAuthorizationInfo;
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
