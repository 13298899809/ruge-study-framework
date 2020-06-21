package com.ruge.framework.aop;

import com.ruge.framework.tx.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: aop事务
 * @date 2020/6/21 13:02
 */
@Component
@Aspect
public class AopTransaction{

    @Resource
    private TransactionUtils transactionUtils;

    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(* com.ruge.service.*.*(..))")
    public void BrokerAspect() {

    }

    // // 异常通知
    @AfterThrowing("BrokerAspect()")
    public void afterThrowing() {
        System.out.println("程序已经回滚");
        // 获取程序当前事务 进行回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    // 环绕通知
    @Around("BrokerAspect()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aop 开启事务");
        TransactionStatus begin = transactionUtils.begin();
        proceedingJoinPoint.proceed();
        transactionUtils.commit(begin);
        System.out.println("aop 提交事务");
    }
}
