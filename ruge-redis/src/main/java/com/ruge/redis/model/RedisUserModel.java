package com.ruge.redis.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/19 21:03
 */
@Data
@Builder
public class RedisUserModel implements Serializable {
    private int id;
    private String name;
}
