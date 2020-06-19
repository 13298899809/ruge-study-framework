package com.ruge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName MybatisPlusApplication
 * @date 2020.06.19 15:01
 */
@MapperScan(value = "com.ruge.mapper")
@SpringBootApplication
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
