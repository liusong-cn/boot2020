package com.bz.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:11411
 * @date: 2020/8/17 9:19
 * 确保是spring管理的组件才能使用configurationproperties
 **/
@ConfigurationProperties(prefix = "system")
@Component
@Data
public class SystemProperties {

    //免认证url
    private String annoUrl;

    //过期时间一天
    private Long jwtTimeOut= 86400L;



}
