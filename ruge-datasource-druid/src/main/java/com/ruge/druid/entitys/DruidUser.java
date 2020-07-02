package com.ruge.druid.entitys;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName DruidUser
 * @date 2020.07.02 11:12
 */
@Data
@Entity
public class DruidUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int money;

    private LocalDate birth = LocalDate.now();
    private LocalDateTime createTime = LocalDateTime.now();
    private LocalDateTime updateTime = LocalDateTime.now();
}
