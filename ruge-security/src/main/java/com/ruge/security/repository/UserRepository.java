package com.ruge.security.repository;

import com.ruge.security.entity.SecurityUsers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName UserRepository
 * @date 2020.07.03 11:17
 */
public interface UserRepository extends JpaRepository<SecurityUsers,Long> {
    SecurityUsers findByUsername(String userName);
}
