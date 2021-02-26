package com.ruge.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.ruge.redis.model.RedisUserModel;
import com.ruge.redis.model.TspMusic;
import com.ruge.redis.repository.TspMusicRepository;
import com.ruge.redis.service.TspMusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/18 20:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class StringRedisKeysTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private TspMusicRepository tspMusicRepository;
    @Resource
    private TspMusicService tspMusicService;

    @Test
    public void test_string_redis() {
        DataType type = stringRedisTemplate.type("222");
        System.out.println(type);


        Set<String> keys = stringRedisTemplate.keys("*");
        keys.forEach(System.out::println);


        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        SetOperations<String, String> stringStringSetOperations = stringRedisTemplate.opsForSet();
        ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        ZSetOperations<String, String> stringStringZSetOperations = stringRedisTemplate.opsForZSet();
        stringRedisTemplate.opsForValue().set("name", "张三");
        stringRedisTemplate.opsForValue().get("name1");
        stringRedisTemplate.opsForValue().set("name2", "张三");
        stringRedisTemplate.opsForValue().set("name3", "张三");

        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    public void test_bound_redis_set() {
        BoundValueOperations<String, String> boundValueOps = stringRedisTemplate.boundValueOps("name");
        Integer append = boundValueOps.append(" 我是张三");
        String s = boundValueOps.get();
        System.out.println(s);
    }

    @Test
    public void test_serializable_redis() {
        /*json 序列化 start*/
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        serializer.setObjectMapper(mapper);
        redisTemplate.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        /*json 序列化 end*/

        RedisUserModel redisUserModel = RedisUserModel.builder().id(1).name("张三").build();
        redisTemplate.opsForValue().set("redisUserModel", redisUserModel);
    }

    @Test
    public void test_series_redis_get() {
        Object redisUserModel = redisTemplate.opsForValue().get("redisUserModel");
        System.out.println(redisUserModel);
    }

    @Test
    public void test_cache_redis() {
        tspMusicService.findAll();
        System.out.println("===");
        tspMusicService.findAll();
    }

    @Test
    public void test_cache_redis2_init() {
        tspMusicService.init();
    }

    @Test
    public void test_cache_redis2_findFirstById() {
        tspMusicService.findFirstByAid("1");
    }

    @Test
    public void test_cache_redis2_findFirstByIdCache() {
        tspMusicService.findFirstByAidCache("1");
    }

    @Test
    public void test_cache_redis2_updateById() {
        tspMusicService.updateByAid(TspMusic.builder().aid("1").build());
    }

    @Test
    public void test_cache_redis2_updateByIdCache() {
        tspMusicService.updateByAidCache(TspMusic.builder().aid("1").build());
    }

    @Test
    public void test_cache_redis2_deleteById() {
        tspMusicService.deleteByAid("1");
    }

    @Test
    public void test_cache_redis2_deleteByIdCache() {
        tspMusicService.deleteByAidCache("1");
    }
}
