package com.ruge.spring5.life;

/**
 * 多例测试
 * scope="prototype"
 */
public class Product2 {
    public Product2() {
        System.out.println("Product2 无参构造方法");
    }
}
