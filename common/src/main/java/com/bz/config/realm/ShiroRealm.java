package com.bz.config.realm;

import com.bz.config.JWTToken;
import com.bz.config.JWTUtil;
import com.bz.entity.User;
import com.bz.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Resource
    private UserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //由于自定义的token重写了principals和credentials，因此才能如此
        String userName = JWTUtil.getUsername(principals.toString());
        //这一步目的在于获得用户的角色信息
        User user = userMapper.findByUserName(userName);
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
        //获取jwt
        String token1 = (String) token.getCredentials();
        String userName = JWTUtil.getUsername(token1);
        if(StringUtils.isBlank(userName))
            throw new AuthenticationException("token校验不通过");
        User user = userMapper.findByUserName(userName);
        if(user == null){
            throw new UnknownAccountException("用户名或密码错误");
        }
        if(!JWTUtil.verify(token1,userName,user.getPassword())){
            throw new IncorrectCredentialsException("token校验不通过");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token1, token1, getName());
        return info;
    }

}
