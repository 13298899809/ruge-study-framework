package com.ruge.redis.repository;

import com.ruge.redis.model.TspMusic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName TspMusicRepository
 * @date 2020.09.16 11:16
 */
public interface TspMusicRepository extends JpaRepository<TspMusic, String> {

    @Query(nativeQuery = true, value = "select distinct aid from tsp_music")
    List<String> findDistinctAid();

    Optional<List<TspMusic>> findAllByAid(String aid);
}
