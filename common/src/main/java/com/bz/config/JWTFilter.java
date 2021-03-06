package com.bz.config;

import com.bz.properties.SystemProperties;
import com.bz.util.SpringContextUtil;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:11411
 * @date: 2020/8/14 18:04
 **/
public class JWTFilter extends BasicHttpAuthenticationFilter {

    private Logger log = LoggerFactory.getLogger(JWTFilter.class);

    private static final  String TOKEN = "Token";

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    public JWTFilter() {
        super();
    }

    @SneakyThrows
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest  httpServletRequest = (HttpServletRequest) request;
        SystemProperties properties = SpringContextUtil.getBean(SystemProperties.class);
        String[] annoUrl = StringUtils.splitByWholeSeparatorPreserveAllTokens(properties.getAnnoUrl(),",");
        boolean match = false;
        for (String s : annoUrl) {
            if(pathMatcher.match(s,httpServletRequest.getRequestURI())){
                match = true;
            }
        }
        if(match){
            return true;
        }
        if(isLoginAttempt(request, response)){
            return executeLogin(request, response);
        }
        return false;
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(TOKEN);
        return token != null ;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(TOKEN);
        JWTToken jwtToken = new JWTToken(token);
        try {
            getSubject(request,response).login(jwtToken);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin",httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-control-Allow-Methods","GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-control-Allow-Headers",httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个 option请求，这里我们给 option请求直接返回正常状态
        if(httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())){
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
