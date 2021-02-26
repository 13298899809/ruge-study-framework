package com.ruge.spring5.aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ruge.wu
 */
public class TestProxy {
    public static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/spring_aop.xml");

    /**
     * 动态代理测试
     */
    @Test
    public void test1() {
        UserService userService = (UserService) CONTEXT.getBean("userService");
        userService.register("admin", "123456");
        userService.login("admin", "123456");
    }
}
