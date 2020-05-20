package com.ruge.spring5.life;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLife {
    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/application.xml");
    /*生命周期---创建阶段~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    /**
     * scope="singleton"
     * 工厂创建的同时  bean也创建
     */
    @Test
    public void test1() {
        // Object product1 = context.getBean("product1");
    }

    /**
     * scope="singleton"
     * spring工厂会在获取对象的同事创建对象
     */
    @Test
    public void test2() {
        Object product2 = context.getBean("product2");
    }

    /**
     * scope="singleton"
     * 同时只想在获取的时候进行对象的创建
     * lazy-init="true"
     */
    @Test
    public void test3() {
        context.getBean("product3");
    }
    /*生命周期---创建阶段~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /*生命周期---初始化阶段~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


    /**
     * implements InitializingBean
     * 创建完对象后会调用afterPropertiesSet()方法  进行一些初始化操作
     */
    @Test
    public void test4() {
        context.getBean("product4");
        context.close();
    }

    /**
     * 创建完对象后会调用init()方法  进行一些初始化操作
     * 销毁方法 只对单例有效
     */
    @Test
    public void test5() {
        context.getBean("product5");
        context.close();
    }







    /*生命周期---初始化阶段~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
}
