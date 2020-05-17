package com.ruge.spring5;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class TestHelloWorld {
    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/application.xml");

    /**
     * spring getBean()
     */
    @Test
    public void test() {
        Object bean = context.getBean("person");
        System.out.println(bean);
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    /**
     * 获取spring容器中所有的bean
     */
    @Test
    public void test2() {
        String[] strings = context.getBeanDefinitionNames();
        Arrays.asList(strings).stream().forEach(e -> {
            System.out.println(e);
        });
        System.out.println(context.getBeanDefinitionCount());
    }

    /**
     * 根据类型获取spring配置文件对应的id的值
     */
    @Test
    public void test3() {
        String[] strings = context.getBeanNamesForType(Person.class);
        Arrays.asList(strings).stream().forEach(e -> {
            System.out.println(e);
        });
    }

    /**
     * 判断是否存在指定id的bean
     */
    @Test
    public void test4() {
        boolean person = context.containsBean("person");
        System.out.println(person);
        boolean person1 = context.containsBeanDefinition("person");
        System.out.println(person1);
    }
}
