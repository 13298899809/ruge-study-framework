package com.ruge.redis.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/26 9:20
 */
@Data
@Entity
public class ProductEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*产品名称*/
    private String name;
    /*产品价格*/
    private int price;
    /*产品库存*/
    private int stock;

    private String pic;

}
