package com.handson.tinyurl.controller;

import com.handson.tinyurl.service.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {
    @Autowired
    Redis redis;

    @RequestMapping(value = "/getkey", method = RequestMethod.GET)
    public String getKey(@RequestParam String key) {
        System.out.println(redis.get(key).toString());
        return redis.get(key).toString();
    }

    @RequestMapping(value = "/setkey", method = RequestMethod.POST)
    public Boolean setKey(@RequestParam String key, @RequestParam String value) {
        return redis.set(key,value);
    }
}
