package sso.utils;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: fengmc
 * @Date: 2018/9/28 17:03
 * @Version 1.0
 */
@Slf4j
public class JedisUtils {

    /**
     * 设置key的有效期，单位是秒
     * @param key
     * @param exTime
     * @return
     */
    public static Long expire(String key,int exTime){
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.expire(key,exTime);
        } catch (Exception e) {
            log.error("expire key:{} error",key,e);
            RedisPool.close(jedis);
            return result;
        }
        RedisPool.close(jedis);
        return result;
    }

    //exTime的单位是秒
    public static String setEx(String key,String value,int exTime){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.setex(key,exTime,value);
        } catch (Exception e) {
            log.error("setex key:{} value:{} error",key,value,e);
            RedisPool.close(jedis);
            return result;
        }
        RedisPool.close(jedis);
        return result;
    }

    public static String set(String key,String value){
        Jedis jedis = null;
        String result = null;

        try {
            jedis = RedisPool.getJedis();
            result = jedis.set(key,value);
        } catch (Exception e) {
            log.error("set key:{} value:{} error",key,value,e);
            RedisPool.close(jedis);
            return result;
        }
        RedisPool.close(jedis);
        return result;
    }

    public static String get(String key){
        Jedis jedis = null;
        String result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            log.error("get key:{} error",key,e);
            RedisPool.close(jedis);
            return result;
        }
        RedisPool.close(jedis);
        return result;
    }

    public static Long del(String key){
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = RedisPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            log.error("del key:{} error",key,e);
            RedisPool.close(jedis);
            return result;
        }
        RedisPool.close(jedis);
        return result;
    }

    public static String setObject(String key,Object value){
        Jedis jedis = null;
        String result = null;

        try {
            jedis = RedisPool.getJedis();
            result = jedis.set(key.getBytes(),serialize(value));
        } catch (Exception e) {
            log.error("set key:{} value:{} error",key,value,e);
            RedisPool.close(jedis);
            return result;
        }
        RedisPool.close(jedis);
        return result;

    }

    public static Object getObject(String key){
        Jedis jedis = null;
        Object unserialize = null;
        try {
            jedis = RedisPool.getJedis();
            byte[] bytes = jedis.get(key.getBytes());
            unserialize = unserialize(bytes);
        } catch (Exception e) {
            log.error("get key:{} error",key,e);
            RedisPool.close(jedis);
            return unserialize;
        }
        RedisPool.close(jedis);
        return unserialize;
    }

    //redis 序列化
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }
    //反序列化
    public static Object unserialize( byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }
}
