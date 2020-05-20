package com.ruge.spring5.spring_druid;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDruid {
    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-druid.xml");

    /**
     * 读取外部文件
     * spring 读取properties测试
     */
    @Test
    public void test1() {
        System.out.println(context.getBean("conn"));
    }
}
