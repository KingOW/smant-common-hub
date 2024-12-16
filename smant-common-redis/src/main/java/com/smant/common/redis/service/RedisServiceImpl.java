package com.smant.common.redis.service;

import com.smant.common.core.constants.CommConstants;
import com.smant.common.core.utils.RamdomUtils;
import com.smant.common.core.utils.StringExtUtils;
import com.smant.common.redis.constants.CacheExpire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component(value = "redisService")
public class RedisServiceImpl implements RedisService {

    @Autowired
    @Qualifier(value = "redisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 获取序列号
     *
     * @param key
     * @return
     */
    @Override
    public long sequence(String key) {
        return this.sequence(key, CacheExpire.EXPIRE_24H);
    }

    /**
     * 获取序列号
     *
     * @param key
     * @param expire
     * @return
     */
    @Override
    public long sequence(String key, long expire) {
        if (StringExtUtils.isEmpty(key)) {
            return 0l;
        }
        long seq = 0l;
        if (!this.redisTemplate.hasKey(StringExtUtils.trimStr(key))) {
            seq = this.redisTemplate.opsForValue().increment(StringExtUtils.trimStr(key));
            this.redisTemplate.expire(key, expire + RamdomUtils.randomInt(CommConstants.NUMBER_100), TimeUnit.SECONDS);
            return seq;
        } else {
            return this.redisTemplate.opsForValue().increment(StringExtUtils.trimStr(key));
        }
    }

    @Override
    public void setCacheObject(String key, Object obj, long expire) {
        this.redisTemplate.opsForValue().set(key, obj);
        this.redisTemplate.expire(key, expire + RamdomUtils.randomInt(CommConstants.NUMBER_100), TimeUnit.SECONDS);
    }

    /**
     * 保存对象
     *
     * @param key
     * @param value
     * @param expire
     */
    @Override
    public void setCacheMap(String key, Map<String, Object> value, long expire) {
        this.redisTemplate.expire(key, expire + RamdomUtils.randomInt(CommConstants.NUMBER_100), TimeUnit.SECONDS);
    }

    @Override
    public  Map<String, Object> getCacheMap(String key) {
       return   this.redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取缓存对象
     *
     * @param key
     * @return
     */
    @Override
    public Object getCacheObject(String key) {
        return this.redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取map缓存
     *
     * @param key
     * @param hashKey
     * @return
     */
    @Override
    public Object getCacheHashValue(String key, String hashKey) {
        return this.redisTemplate.opsForHash().get(key, hashKey);
    }

    @Override
    public boolean existKey(String key) {
        return this.redisTemplate.hasKey(key);
    }

    @Override
    public boolean existHashKey(String key, String hashKey) {
        return this.redisTemplate.opsForHash().hasKey(key,hashKey);
    }

    public boolean expire(String key, long timeout, TimeUnit unit) {
        return this.redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 删除缓存信息
     *
     * @param key
     */
    @Override
    public void delCacheObject(String key) {
        if (StringExtUtils.isTrimEmpty(key)) {
            return;
        }
        this.redisTemplate.delete(StringExtUtils.trimStr(key));
    }

    /**
     * 批量删除缓存信息：一次最多删除100条信息
     *
     * @param keys
     */
    @Override
    public void batchDelCacheObjec(List<String> keys) {
        if (keys == null || keys.size() == 0) {
            return;
        }
        this.redisTemplate.delete(keys.subList(CommConstants.NUMBER_0, CommConstants.NUMBER_10 - 1));
    }

    @Override
    public void delCacheHash(String key, String... hashKey) {
        this.redisTemplate.opsForHash().delete(key,hashKey);
    }

    /**
     * 获取key剩余过期时间，以s为单位
     *
     * @param key
     * @return
     */
    @Override
    public Long keyExpire(String key) {
        // 获取键的剩余生存时间，单位为秒
        Long expiration = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expiration;
    }
}
