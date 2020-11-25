package com.bz.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author:11411
 * @date: 2020/8/14 17:33
 **/
@Data
@AllArgsConstructor
public class JWTToken implements AuthenticationToken {

    private static final long serialVersionUID = 1234;
    //自定义token
    private String token;
    //自定义过期时间
    private String expireAt;

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    public JWTToken(String token) {
        this.token = token;
    }
}
