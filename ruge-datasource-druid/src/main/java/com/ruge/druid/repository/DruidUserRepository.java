package com.ruge.druid.repository;

import com.ruge.druid.entitys.DruidUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName DruidUserRepository
 * @date 2020.07.02 11:14
 */
public interface DruidUserRepository extends JpaRepository<DruidUser, Long> {
    Optional<DruidUser> findByName(String name);
}
