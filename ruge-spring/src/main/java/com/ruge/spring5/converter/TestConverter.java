package com.ruge.spring5.converter;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestConverter {
    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring_converter.xml");

    @Test
    public void test1() {
        System.out.println(context.getBean("person"));
    }
}
