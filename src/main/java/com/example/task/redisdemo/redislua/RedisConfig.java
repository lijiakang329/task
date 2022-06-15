package com.example.task.redisdemo.redislua;

/**
 * @description: config
 * @author: jiakang
 * @create: 2022-06-14 17:58
 **/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;


/**
 * @description: config
 * @author: jiakang
 * @create: 2022-06-05 15:58
 **/
@Configuration
public class RedisConfig {
    @javax.annotation.Resource
    RedisConnectionFactory factory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }
    @Bean
    public RedisScript<String> redisScript() {
        DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
        Resource resource =  new ClassPathResource("checkandset.lua");
        ScriptSource scriptSource = new ResourceScriptSource(resource);
        redisScript.setResultType(String.class);
        redisScript.setScriptSource(scriptSource);
        return redisScript;
    }

}

