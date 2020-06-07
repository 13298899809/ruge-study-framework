package com.ruge.spring5.aspectj.bug;

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
public class MyBugAspectj {


    @Around("execution(* *register(..))")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        /*原始方法返回值*/
        System.out.println("bug MyAspectj Around");
        Object ret = proceedingJoinPoint.proceed();
        return ret;
    }

}
