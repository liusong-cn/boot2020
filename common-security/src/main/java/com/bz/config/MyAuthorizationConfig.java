package com.bz.config;

import com.bz.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author:11411
 * @date: 2020/9/8 10:25
 **/
@Configuration
//结合oauth2创建授权服务器
@EnableAuthorizationServer
@Order(2)
public class MyAuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private TokenStore redisTokenStore;

    /**
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)//配置认证管理器，则security定义的鉴权被忽略
                .userDetailsService(userDetailService);//password模式必须配置鉴权
//                .tokenStore(redisTokenStore);//redis存储token
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()//允许/oauth相关的访问
                .checkTokenAccess("isAuthenticated()")
                .tokenKeyAccess("isAuthenticated()");
    }

    /**
     * 配置client信息,可配置在application.yml中,需注意secret需加密
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("security")
                .secret(passwordEncoder.encode("security1234"))
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(86400)
                .redirectUris("http://www.baidu.com")
                .scopes("all")
                .autoApprove(true)
                .authorizedGrantTypes("authorization_code","password","refresh_token");
    }
}
