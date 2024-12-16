package com.smant.common.redis.config;

import com.smant.common.core.utils.StringExtUtils;
import com.smant.common.redis.serializer.FastJson2JsonRedisSerializer;
import io.lettuce.core.ReadFrom;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


@Configuration
public class RedisConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);
    private static final String SPRING_REDIS_CLIENT_JEDIS = "jedis";
    private static final String SPRING_REDIS_CLIENT_LETTUCE = "lettuce";

    @Value("${spring.data.redis.host:127.0.0.1}")
    private String host;

    @Value("${spring.data.redis.port:6379}")
    private int port;

    @Value("${spring.data.redis.username:}")
    private String username;

    @Value("${spring.data.redis.password:}")
    private String password;


    @Value("${spring.data.redis.lettuce.pool.max-active:8}")
    private int lettuceMaxActive;

    @Value("${spring.data.redis.lettuce.pool.max-idle:8}")
    private int lettuceMaxIdle;

    @Value("${spring.data.redis.lettuce.pool.min-idle:0}")
    private int lettuceMinIdle;

    @Value("${spring.data.redis.lettuce.pool.max-wait:100}")
    private int lettuceMaxWait;


    /**
     * Lettuce
     */
    @Bean(value = "redisConnectionFactory")
    @ConditionalOnProperty(value = "spring.data.redis.client-type", havingValue = SPRING_REDIS_CLIENT_LETTUCE)
    public RedisConnectionFactory lettuceConnectionFactory() {
        LOGGER.info("构建 LettuceConnectionFactory");
        RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration(host, port);
        if (!StringExtUtils.isEmpty(username)) {
            redisConfiguration.setUsername(username);
        }
        if (!StringExtUtils.isEmpty(password)) {
            redisConfiguration.setPassword(password);
        }
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(lettuceMaxIdle);
        poolConfig.setMinIdle(lettuceMinIdle);
        poolConfig.setMaxWait(Duration.of(lettuceMaxWait, ChronoUnit.MILLIS));
        poolConfig.setMaxTotal(lettuceMaxActive);
        LOGGER.info("配置连接池");
        LettucePoolingClientConfiguration lettucePoolingClientConfig = LettucePoolingClientConfiguration.builder().poolConfig(poolConfig).readFrom(ReadFrom.MASTER_PREFERRED)
                .commandTimeout(Duration.of(10000, ChronoUnit.MILLIS)) // 设置命令超时时间（毫秒）
                .shutdownTimeout(Duration.of(50000, ChronoUnit.MILLIS)) // 设置关闭超时时间（毫秒）
                .build();
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisConfiguration, lettucePoolingClientConfig);
        lettuceConnectionFactory.setEagerInitialization(true);
        lettuceConnectionFactory.setShareNativeConnection(true);
        return lettuceConnectionFactory;
    }

    /**
     * Jedis
     */
    @Bean(value = "redisConnectionFactory")
    @ConditionalOnProperty(value = "spring.data.redis.client-type", havingValue = SPRING_REDIS_CLIENT_JEDIS)
    public RedisConnectionFactory jedisConnectionFactory() {
        LOGGER.info("构建 JedisConnectionFactory");
        return new JedisConnectionFactory();
    }

    /**
     * redis template
     *
     * @param factory
     * @return
     */
    @Bean(value = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(
            @Autowired @Qualifier(value = "redisConnectionFactory") RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        FastJson2JsonRedisSerializer<Object> json2JsonRedisSerializer = new FastJson2JsonRedisSerializer<>(Object.class);
        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        StringRedisSerializer serializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setValueSerializer(json2JsonRedisSerializer);
        //hash的value也采用jackson序列化方式
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setHashValueSerializer(json2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
//    /**
//     * redis template
//     * @param factory
//     * @return
//     */
//    @Bean(value = "reactiveRedisTemplate")
//    public ReactiveRedisTemplate<String, String> reactiveRedisTemplate(
//            @Autowired @Qualifier(value = "redisConnectionFactory") RedisConnectionFactory connectionFactory) {
//        ReactiveRedisTemplate<String, Object> reactiveRedisTemplate = new ReactiveRedisTemplate<>(connectionFactory, RedisSerializationContext.string());
//        reactiveRedisTemplate.setConnectionFactory(factory);
//        FastJson2JsonRedisSerializer<Object> json2JsonRedisSerializer = new FastJson2JsonRedisSerializer<>(Object.class);
//        // 使用StringRedisSerializer来序列化和反序列化redis的key值
//        StringRedisSerializer serializer = new StringRedisSerializer();
//        reactiveRedisTemplate.setKeySerializer(serializer);
//        reactiveRedisTemplate.setValueSerializer(json2JsonRedisSerializer);
//        //hash的value也采用jackson序列化方式
//        reactiveRedisTemplate.setHashKeySerializer(serializer);
//        reactiveRedisTemplate.setHashValueSerializer(json2JsonRedisSerializer);
//        reactiveRedisTemplate.afterPropertiesSet();
//        return reactiveRedisTemplate;
//    }

}
