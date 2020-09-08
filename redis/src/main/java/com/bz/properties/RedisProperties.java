package com.bz.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:11411
 * @date: 2020/9/8 15:58
 **/
@ConfigurationProperties(prefix = "custom.lettuce.redis")
@Component
public class RedisProperties {

    /**
     * 是否开启Lettuce Redis
     */
    private Boolean enable = true;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "LettuceRedisProperties{" +
                "enable=" + enable +
                '}';
    }
}
