package com.ruge.redis.service;

import com.ruge.redis.model.TspMusic;
import com.ruge.redis.repository.TspMusicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/19 22:53
 */
@Slf4j
@Service
@CacheConfig(cacheNames = {"tspMusic"})
public class TspMusicService {
    @Resource
    private TspMusicRepository tspMusicRepository;

    public void init() {
        tspMusicRepository.deleteAll();
        for (int i = 0; i < 100; i++) {
            TspMusic build = TspMusic.builder()
                    .musicName("张" + i + "的歌")
                    .aid(String.valueOf(i))
                    .build();
            TspMusic save = tspMusicRepository.save(build);
            log.info("TspMusic:{}", save);
        }
    }

    public TspMusic findFirstByAid(String aid) {
        TspMusic tspMusic = tspMusicRepository.findFirstByAid(aid).orElse(new TspMusic());
        log.info("findFirstByAid:{}", tspMusic);
        return tspMusic;
    }

    @Cacheable(key = "#aid")
    public TspMusic findFirstByAidCache(String aid) {
        TspMusic tspMusic = tspMusicRepository.findFirstByAid(aid).orElse(new TspMusic());
        log.info("findFirstByIdCache:{}", tspMusic);
        return tspMusic;
    }

    public TspMusic updateByAid(TspMusic music) {
        TspMusic tspMusic = tspMusicRepository.findFirstByAid(music.getAid()).orElse(new TspMusic());
        tspMusic.setMusicName("张0的歌");
        tspMusicRepository.save(tspMusic);
        log.info("updateByAid:{}", tspMusic);
        return tspMusic;
    }

    @CachePut(key = "#music.aid")
    public TspMusic updateByAidCache(TspMusic music) {
        TspMusic tspMusic = tspMusicRepository.findFirstByAid(music.getAid()).orElse(new TspMusic());
        tspMusic.setMusicName("张0的歌");
        tspMusicRepository.save(tspMusic);
        log.info("updateByAidCache:{}", tspMusic);
        return tspMusic;
    }

    public void deleteByAid(String aid) {
        tspMusicRepository.deleteByAid(aid);
    }

    @CacheEvict(key = "#aid")
    @Transactional(rollbackFor = Exception.class)
    public void deleteByAidCache(String aid) {
        tspMusicRepository.deleteByAid(aid);
    }

    /**
     * @return {@Link TspMusic}
     * @Cacheable(value="user", key ="#p0")
     */
    @Cacheable(value = "user")
    public List<TspMusic> findAll() {
        return tspMusicRepository.findAll();
    }
}
