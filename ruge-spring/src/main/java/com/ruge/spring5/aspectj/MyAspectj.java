package com.ruge.spring5.aspectj;

import com.ruge.spring5.aop.AopAround;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspect 声明该类为切面类
 * 1 额外功能 {@link AopAround}
 * 2 切入点
 */
@Aspect
public class MyAspectj {

    @Pointcut("execution(* *(..))")
    public void myPointCut(){

    }

    @Around("execution(* *(..))")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        /*原始方法返回值*/
        System.out.println("MyAspectj Around");
        Object ret = proceedingJoinPoint.proceed();
        return ret;
    }

    @Around(value = "myPointCut()")
    public Object Around2(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        /*原始方法返回值*/
        System.out.println("MyAspectj2 Around");
        Object ret = proceedingJoinPoint.proceed();
        return ret;
    }
}
