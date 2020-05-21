package com.ruge.spring5.proxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Before implements MethodBeforeAdvice {
    /**
     * 把需要运行在原始方法执行之前的功能，卸载Before方法中
     *
     * @param method  原始方法，被增强的方法
     * @param objects 原始方法传递参数
     * @param o       增强的原始对象
     */
    @Override
    public void before(Method method, Object[] objects, Object o) {
        String name = method.getName();
        System.out.println("before---method-->" + name);
        System.out.println("before--参数-->" + Arrays.asList(objects));
        System.out.println("before--Object-->" + o);
    }
}
