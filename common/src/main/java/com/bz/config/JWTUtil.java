package com.bz.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 * @author:11411
 * @date: 2020/8/14 17:44
 **/
public class JWTUtil {

    private static Logger log = LoggerFactory.getLogger(JWTUtil.class);

    //milliSecond
    private static final long EXPIRE_TIME = 500000;

    /**
     *
     * @param token 秘钥
     * @param username 用户名
     * @param secret 密码
     * @return
     */
    public static  boolean verify(String token, String username, String secret){
        //secret等同于salt,可以拿密码或者其他作为salt，一般交由服务端保存
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier jwtVerifier = JWT.require(algorithm)
                .withClaim("username",username)
                .build();
        jwtVerifier.verify(token);
        log.info("token is valid");
        return true;
    }

    /**
     * 从token中获取用户名
     * @param token
     * @return
     */
    public static String getUsername(String token){
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim("username").asString();
    }

    /**
     * 生成签名
     * @param username
     * @param secret
     * @return
     */
    public static String sign(String username, String secret){
        username = StringUtils.lowerCase(username);
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create().withClaim("username",username)
                .withExpiresAt(date)
                .sign(algorithm);

    }
}
