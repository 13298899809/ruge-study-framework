package com.ruge.redis.repository;

import com.ruge.redis.model.OrderEntity;
import com.ruge.redis.model.TspMusic;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/26 9:20
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByProductId(Long productId);

}
