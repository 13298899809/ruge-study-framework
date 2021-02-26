package com.ruge.redis.service;

import com.ruge.redis.model.OrderEntity;
import com.ruge.redis.model.ProductEntity;
import com.ruge.redis.repository.OrderRepository;
import com.ruge.redis.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/26 9:20
 */
@Slf4j
@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private ProductRepository productRepository;

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate redisTemplate;

    public static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    @PostConstruct
    public void init() {
        log.info("========================================");
        redisTemplate.opsForHash().put("key1", "item1", "value1");
        redisTemplate.opsForHash().put("key2", "item2", "value2");
        redisTemplate.opsForHash().put("key3", "item3", "value3");
        redisTemplate.opsForHash().put("key4", "item4", "value4");
        redisTemplate.expire("key1", 4, TimeUnit.DAYS);

        productRepository.findAll().forEach(e -> {
            stringRedisTemplate.opsForValue().set("PRODUCT_" + e.getId(), e.getStock() + "");
        });

    }

    @Transactional(rollbackFor = Exception.class)
    public void secKillV1(long productId) {
        productRepository.findById(productId).ifPresent(e -> {
            if (e.getStock() <= 0) {
                System.out.println("库存没有了");
            } else {
                /*减少库存*/
//            e.setStock(e.getStock() - 1);
                int i = productRepository.reduceStocks(productId);
                if (i > 0) {
                    /*创建订单*/
                    OrderEntity orderEntity = new OrderEntity();
                    orderEntity.setProductId(productId);
                    orderEntity.setAmount(e.getPrice());
                    orderRepository.save(orderEntity);
                }
            }
        });
    }

    @Transactional(rollbackFor = Exception.class)
    public void secKillV2(long productId) {
        Long stock = stringRedisTemplate.opsForValue().decrement("PRODUCT_" + productId);
        try {
            if (stock >= 0) {
                productRepository.findById(productId).ifPresent(e -> {
                    if (e.getStock() <= 0) {
                        System.out.println("mysql 库存没有了");
                    } else {
                        /*减少库存*/
                        int i = productRepository.reduceStocks(productId);
                        if (i > 0) {
                            /*创建订单*/
                            OrderEntity orderEntity = new OrderEntity();
                            orderEntity.setProductId(productId);
                            orderEntity.setAmount(e.getPrice());
                            orderRepository.save(orderEntity);
                        }
                    }
                });
            } else {
                // 货物没有了 将库存增加值0 同时直接返回
                stringRedisTemplate.opsForValue().increment("PRODUCT_" + productId);
                System.out.println("es 库存没有了");
                return;
            }
        } catch (Exception e) {
            stringRedisTemplate.opsForValue().increment("PRODUCT_" + productId);
            e.printStackTrace();
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void secKillV3(long productId) {
        if (null != concurrentHashMap.get("PRODUCT_" + productId)) {
            return;
        }
        Long stock = stringRedisTemplate.opsForValue().decrement("PRODUCT_" + productId);
        try {
            if (stock >= 0) {
                productRepository.findById(productId).ifPresent(e -> {
                    if (e.getStock() <= 0) {
                        System.out.println("mysql 库存没有了");
                    } else {
                        /*减少库存*/
                        int i = productRepository.reduceStocks(productId);
                        if (i > 0) {
                            /*创建订单*/
                            OrderEntity orderEntity = new OrderEntity();
                            orderEntity.setProductId(productId);
                            orderEntity.setAmount(e.getPrice());
                            orderRepository.save(orderEntity);
                        }
                    }
                });
            } else {
                concurrentHashMap.put("PRODUCT_" + productId, true);
                // 货物没有了 将库存增加值0 同时直接返回
                stringRedisTemplate.opsForValue().increment("PRODUCT_" + productId);
                System.out.println("es 库存没有了");
            }
        } catch (Exception e) {
            concurrentHashMap.remove("PRODUCT_" + productId);
            stringRedisTemplate.opsForValue().increment("PRODUCT_" + productId);
            e.printStackTrace();
        }
    }
}
