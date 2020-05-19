package com.ruge.spring5.scope;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/application.xml");

    /**
     * 测试简单对象的创建次数
     * scope="singleton"
     * 应用场景： 能被共用且线程安全
     */
    @Test
    public void test1() {
        Object account1 = context.getBean("account1");
        Object account2 = context.getBean("account1");
        System.out.println(account1);
        System.out.println(account2);
    }

    /**
     * 测试简单对象的创建次数
     * scope="prototype"
     * 应用场景：不能被共用或线程不安全
     */
    @Test
    public void test2() {
        Object account1 = context.getBean("account2");
        Object account2 = context.getBean("account2");
        System.out.println(account1);
        System.out.println(account2);
    }


    @Test
    public void test3() {
        Object account1 = context.getBean("account1");
        Object account2 = context.getBean("account2");
        System.out.println(account1);
        System.out.println(account2);
    }
}
