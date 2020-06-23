package com.timain.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/6/23 15:06
 */
@Configuration
public class RedissonConfig {
    
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + host + ":" + port);
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}
