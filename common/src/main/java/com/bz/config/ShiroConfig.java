package com.bz.config;

import com.bz.config.realm.ShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;

/**
 * @author:11411
 * @date: 2020/8/10 16:29
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //在过滤器链中加入自定义的jwtfilter
        LinkedHashMap<String, Filter> filters = new LinkedHashMap<>();
        filters.put("jwt",new JWTFilter());
        shiroFilterFactoryBean.setFilters(filters);

        //设置登录url
        shiroFilterFactoryBean.setLoginUrl("/login");
        //设置成功页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //设置未鉴权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        LinkedHashMap<String, String> filterchainDefinationMap = new LinkedHashMap<>();
        //配置静态资源不拦截
        filterchainDefinationMap.put("/css/**","anon");
        filterchainDefinationMap.put("/js/**","anon");
        filterchainDefinationMap.put("/fonts/**","anon");
        filterchainDefinationMap.put("/druid/**","anon");
        //配置登出页面不拦截,由shiro实现
        filterchainDefinationMap.put("/logout","logout");
        filterchainDefinationMap.put("/","anon");
        //登录页面不拦截
        filterchainDefinationMap.put("/login","anon");
        //配置其余url都需要认证,此处没有使用官方的authc这个filter,使用自定义的filter
        filterchainDefinationMap.put("/**","jwt");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterchainDefinationMap);
        return shiroFilterFactoryBean;
    }

    //配置安全管理器，所有subject归其管理
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    //自定义的realm实现
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }

    //开启权限注解功能
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //配合权限注解使用
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
}
