package com.example.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, Object object) {
        try {
            redisTemplate.opsForValue().set(key, object);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.log.debug(e.getMessage());
        }
    }

    public void set(String key, Object object, long time) {
        try {
            redisTemplate.opsForValue().set(key, object, time, TimeUnit.MINUTES);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.log.debug(e.getMessage());
        }
    }

    public boolean setExpire(String key, long time) {
        try {
            if (time > 0) {
                return redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.log.debug(e.getMessage());
            return false;
        }
    }

    public Object get(String key) {
        try {
            Object obj = new Object();
            obj = redisTemplate.opsForValue().get(key);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.log.debug(e.getMessage());
            return null;
        }
    }

    public long getExpire(String key) {
        try {
            return redisTemplate.getExpire(key, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.log.debug(e.getMessage());
            return 0;
        }
    }

    public boolean delete(String key) {
        try {
            return redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.log.debug(e.getMessage());
            return false;
        }
    }

    public void delete(String... keys){
        try{
            if(keys.length==1){
                redisTemplate.delete(keys[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(keys));
            }
        }catch (Exception e){
            e.printStackTrace();
            LoggerUtil.log.debug(e.getMessage());
        }
    }

    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            LoggerUtil.log.debug(e.getMessage());
            return false;
        }
    }

    public String createToken(String username){
        return "";
    }
}
