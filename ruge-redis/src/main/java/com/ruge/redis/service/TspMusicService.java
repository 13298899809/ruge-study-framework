package com.ruge.redis.service;

import com.ruge.redis.model.TspMusic;
import com.ruge.redis.repository.TspMusicRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/19 22:53
 */
@Service
@CacheConfig()
public class TspMusicService {
    @Resource
    private TspMusicRepository tspMusicRepository;

    //    @Cacheable(value="user", key ="#p0")
    @Cacheable(value = "user")
    public List<TspMusic> findAll() {
        return tspMusicRepository.findAll();
    }
}
