package com.baizhi.controller;

import com.baizhi.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class Rediscotroller {
    @Autowired
    RedisUtil redis;
    @RequestMapping("/set")
    public void setRedis(String values){
        redis.set(values,values);
    }
}
