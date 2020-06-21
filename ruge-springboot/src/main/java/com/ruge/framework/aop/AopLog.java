//package com.ruge.framework.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
///**
// * @author 嘿丷如歌
// * @version V1.0
// * @Description:
// * @date 2020/6/21 11:34
// */
//@Component
//@Aspect
//public class AopLog {
//
//    /**
//     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
//     * 通过@Pointcut注解声明频繁使用的切点表达式
//     */
//    @Pointcut("execution(* com.ruge.service.*.*(..))")
//    public void BrokerAspect() {
//
//    }
//
//    // 前置通知
//    @Before("BrokerAspect()")
//    public void begin() {
//        System.out.println("前置通知");
//    }
//
//    // 后置通知
//    @After("BrokerAspect()")
//    public void commit() {
//        System.out.println("后置通知");
//    }
//
//    // 运行通知
//    @AfterReturning("BrokerAspect()")
//    public void returning() {
//        System.out.println("运行通知");
//    }
//
//    // 异常通知
//    @AfterThrowing("BrokerAspect()")
//    public void afterThrowing() {
//        System.out.println("异常通知");
//    }
//
//    @Around("BrokerAspect()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        try {
//            System.out.println("环绕通知开始");
//            return joinPoint.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//            throw e;
//        } finally {
//            System.out.println("环绕通知结束");
//        }
//    }
//}
