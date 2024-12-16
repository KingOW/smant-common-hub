package com.smant.common.redis.service;


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface RedisService {

    /**
     * 获取序列号
     * @param key
     * @return
     */
     long sequence(String key);

    /**
     * 获取序列号
     * @param key
     * @param expire 有效期，单位为秒
     * @return
     */
    long sequence(String key, long expire);


    /**
     * 保存对象
     * @param key
     * @param obj
     * @param expire 有效期，单位为秒
     */
    void setCacheObject(String key,Object obj,long expire);

    /**
     * 保存对象
     * @param key
     * @param value
     */
    void setCacheMap(String key, Map<String,Object> value,long expire);
    public Map<String, Object> getCacheMap(String key);
    /**
     * 获取缓存对象
     * @param key
     * @return
     */
    Object getCacheObject(String key);

    /**
     * 获取map缓存
     * @param key
     * @param hashKey
     * @return
     */
    Object getCacheHashValue(String key,String hashKey);

    /**
     * 是否存在
     * @param key
     * @return
     */
    boolean existKey(String key);
    boolean existHashKey(String key,String hashKey);
    /**
     * 设置缓存有效期
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    boolean expire(String key, long timeout, TimeUnit unit);

    /**
     * 删除缓存信息
     * @param key
     */
     void delCacheObject(String key);

    /**
     * 批量删除缓存信息：一次最多删除100条信息
     * @param keys
     */
    void batchDelCacheObjec(List<String> keys);

    /**
     * 删除hash
     * @param key
     * @param hashKeys
     */
    void delCacheHash(String key,String... hashKeys);

    /**
     * 获取key剩余过期时间，以s为单位
     * @param key
     * @return
     */
    Long keyExpire(String key);
}
