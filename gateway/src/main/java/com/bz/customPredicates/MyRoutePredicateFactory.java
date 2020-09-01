package com.bz.customPredicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author:11411
 * @date: 2020/8/31 14:15
 **/
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {


    public MyRoutePredicateFactory() {
        super(Config.class);
    }

    //自定义一个predicate,要求request中必须包含指定名称的参数
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            return exchange.getRequest().getQueryParams().keySet().contains(config.name);
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("name");
    }

    public static class Config{

        public String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
