package com.example.task.redisdemo.redislua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @description: test
 * @author: jiakang
 * @create: 2022-06-14 16:37
 **/
@RestController
public class DemoClass {
    @Resource
    public RedisTemplate redisTemplate;

    @GetMapping("/deincr")
    public String deincrByDefault() {
        System.out.println("---------start--------");
        int number = Integer.parseInt((String) Objects.requireNonNull(redisTemplate.opsForValue().get("mu")));//获取库存数量
        System.out.println("剩余库存: " + number);
        if (number > 0) {//并发场景下100%会拿到错误的数据
            redisTemplate.opsForValue().decrement("mu", 1);
            System.out.println("扣减后库存为: " + redisTemplate.opsForValue().get("mu"));
        }
        System.out.println("---------end----------");
        return "sucess";
    }


}
