package com.ruge.spring5.life;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;

public class Product5 {
    public Product5() {
        System.out.println("Product5 无参构造方法");
    }


    public void init() {
        System.out.println("Product5 --> init");
    }

    public void destory() {
        System.out.println("Product5 --> destory");
    }
}
