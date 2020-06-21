package com.ruge.repository;

import com.ruge.entity.BootUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/20 19:45
 */
public interface BootUserRepository extends JpaRepository<BootUser, Long> {

    Optional<BootUser> findByName(String name);
}
