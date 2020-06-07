package com.ruge.spring5.aspectj;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectj {

    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring_aspectj.xml");

    /**
     * aspectj代理测试
     */
    @Test
    public void test1() {
        UserService userService = (UserService) context.getBean("userService");
        userService.register("admin", "123456");
        userService.login("admin", "123456");
    }
}
