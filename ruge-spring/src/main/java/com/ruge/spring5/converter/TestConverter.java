package com.ruge.spring5.converter;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author ruge.wu
 */
public class TestConverter {
    public static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/spring_converter.xml");

    @Test
    public void test1() {
        System.out.println(CONTEXT.getBean("person"));
    }
}
