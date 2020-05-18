package com.ruge.spring5.factoryBean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {

    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/application.xml");


    @Test
    public void test1() {
        Object connection = context.getBean("connection");
        System.out.println(connection);
    }
}
