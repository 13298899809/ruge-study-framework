package com.ruge.redis.controller;

import com.ruge.redis.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/26 9:19
 */
@RestController
@RequestMapping("secKill")
public class RedisSecKillController {

    @Resource
    private OrderService orderService;

    @RequestMapping("v1")
    public Map<String, Object> v1(long productId) {
        Map<String, Object> map = new HashMap<>();
        orderService.secKill_v1(productId);
        return map;
    }

    @RequestMapping("v2")
    public Map<String, Object> v2(long productId) {
        Map<String, Object> map = new HashMap<>();
        orderService.secKill_v2(productId);
        return map;
    }

    @RequestMapping("v3")
    public Map<String, Object> v3(long productId) {
        Map<String, Object> map = new HashMap<>();
        orderService.secKill_v3(productId);
        return map;
    }
}
