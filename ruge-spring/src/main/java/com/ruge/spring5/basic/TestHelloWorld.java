package com.ruge.spring5.basic;

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
     * getBeanDefinitionNames()
     * 获取spring容器中所有的bean
     * id的默认值 com.ruge.spring5.Person#0
     * 应用场景  如果这个bean只需要使用一次  则可以省略id
     * 如果这个bean会使用多次 或者被其他bean引用 则需要设置id
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
     * getBeanNamesForType()
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
     * containsBean()
     * containsBeanDefinition()
     * 判断是否存在指定id的bean
     *
     * containsBeanDefinition不能判断id有个先决条件：xml中的bean需要同时配置id和name属性，
     * containsBeanDefinition才会返回false，如果xml中的bean只配置name，而没有id属性，
     * containsBeanDefinition("name")也是返回true的
     */
    @Test
    public void test4() {
        System.out.println(context.containsBean("person1"));
        System.out.println(context.containsBean("p"));
        System.out.println(context.containsBeanDefinition("person1"));
        System.out.println(context.containsBeanDefinition("p"));
    }

    /**
     * getBean("p")
     * 通过name 获取bean 别名
     * name 可以定义多个
     */
    @Test
    public void test5() {
        Object bean = context.getBean("p");
        Object bean1 = context.getBean("p1");
        Object bean2 = context.getBean("p2");
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(bean2);
    }

}
