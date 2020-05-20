package com.ruge.spring5.life;

/**
 * 懒加载测试
 * scope="singleton" lazy-init="true"
 */
public class Product3 {
    public Product3() {
        System.out.println("Product3 无参构造方法");
    }
}
