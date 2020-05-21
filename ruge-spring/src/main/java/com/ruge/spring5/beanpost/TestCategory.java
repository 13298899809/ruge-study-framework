package com.ruge.spring5.beanpost;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCategory {
    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-category.xml");

    /**
     * 测试 BeanPostProcessor
     */
    @Test
    public void test1() {
        System.out.println(context.getBean("category"));
    }

}
