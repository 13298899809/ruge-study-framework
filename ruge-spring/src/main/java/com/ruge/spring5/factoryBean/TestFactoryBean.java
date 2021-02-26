package com.ruge.spring5.factoryBean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ruge.wu
 */
public class TestFactoryBean {

    public static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/application.xml");


    @Test
    public void test1() {
        Object connection = CONTEXT.getBean("connection");
        System.out.println(connection);
    }
}
