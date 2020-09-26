package com.ruge.redis.repository;

import com.ruge.redis.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/26 9:20
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "update Product_Entity set stock = stock-1 where stock>0 and id = ?1")
    int reduceStocks(long productId);
}
