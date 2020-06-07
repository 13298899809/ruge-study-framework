package com.ruge.spring5.aspectj.bug;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBugAspectj {

    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring_aspectj.xml");

    /**
     * aspectj代理测试
     */
    @Test
    public void test1() {
        BugUserService userService = (BugUserService) context.getBean("userService_bug");
        userService.register("admin", "123456");
        userService.login("admin", "123456");
    }
}
