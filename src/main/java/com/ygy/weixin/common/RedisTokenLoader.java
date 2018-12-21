package com.ygy.weixin.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.weixin4j.loader.ITokenLoader;
import org.weixin4j.model.base.Token;

/**
 * project_name: springboot_weixin
 * describe: 微信token redis存储
 *
 * @author : yanguangyuan
 * creat_date: 2018-12-18 11:25
 **/
@Component
public class RedisTokenLoader implements ITokenLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisTokenLoader.class);
    /**
     * 微信token键
     */
    private final String ACCESS_TOKEN_KEY = "weixin_token";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Token get() {
        String token = stringRedisTemplate.opsForValue().get(ACCESS_TOKEN_KEY);
        LOGGER.info("获取到微信access_token:{}",token);
        return JSON.parseObject(token,Token.class);
    }

    @Override
    public void refresh(Token token) {
        LOGGER.info("刷新微信 access_token:{}",token.toString());
        String accessToken = JSON.toJSONString(token);
        //提前过期
        stringRedisTemplate.opsForValue().set(ACCESS_TOKEN_KEY,accessToken,token.getExpires_in()-1000L);

    }
}
