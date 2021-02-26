package com.ruge.spring5.beanpost;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ruge.wu
 */
public class TestCategory {
    public static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/spring-category.xml");

    /**
     * 测试 BeanPostProcessor
     */
    @Test
    public void test1() {
        System.out.println(CONTEXT.getBean("category"));
    }

}
