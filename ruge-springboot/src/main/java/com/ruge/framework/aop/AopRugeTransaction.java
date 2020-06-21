//package com.ruge.framework.aop;
//
//import com.ruge.framework.annotation.RugeTransaction;
//import com.ruge.framework.tx.TransactionUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.TransactionStatus;
//
//import javax.annotation.Resource;
//import java.lang.reflect.Method;
//
///**
// * @author 嘿丷如歌
// * @version V1.0
// * @Description: aop 自定义事务的实现
// * @date 2020/6/21 21:44
// */
//
//@Aspect
//@Component
//public class AopRugeTransaction {
//    @Resource
//    private TransactionUtils transactionUtils;
//
//    @Pointcut("execution(* com.ruge.service.*.*(..))")
//    public void BrokerAspect() {
//
//    }
//
//    // 使用异常通知进行 回滚事务
//    @AfterThrowing("BrokerAspect()")
//    public void afterThrowing() {
//        // 获取当前事务进行回滚
//        transactionUtils.rollback();
//    }
//
//    // 环绕通知 在方法之前和之后处理事情
//    @Around("BrokerAspect()")
//    public void around(ProceedingJoinPoint pjp) throws Throwable {
//
//        // 1.获取该方法上是否加上注解
//        RugeTransaction rugeTransaction = getMethodExtTransaction(pjp);
//        TransactionStatus transactionStatus = begin(rugeTransaction);
//        // 2.调用目标代理对象方法
//        pjp.proceed();
//        // 3.判断该方法上是否就上注解
//        commit(transactionStatus);
//    }
//
//    private TransactionStatus begin(RugeTransaction rugeTransaction) {
//        if (rugeTransaction == null) {
//            return null;
//        }
//        // 2.如果存在事务注解,开启事务
//        return transactionUtils.begin();
//    }
//
//    private void commit(TransactionStatus transactionStatus) {
//        if (transactionStatus != null) {
//            // 5.如果存在注解,提交事务
//            transactionUtils.commit(transactionStatus);
//        }
//
//    }
//
//    // 获取方法上是否存在事务注解
//    private RugeTransaction getMethodExtTransaction(ProceedingJoinPoint pjp)
//            throws NoSuchMethodException, SecurityException {
//        String methodName = pjp.getSignature().getName();
//        // 获取目标对象
//        Class<?> classTarget = pjp.getTarget().getClass();
//        // 获取目标对象类型
//        Class<?>[] par = ((MethodSignature) pjp.getSignature()).getParameterTypes();
//        // 获取目标对象方法
//        Method objMethod = classTarget.getMethod(methodName, par);
//        RugeTransaction extTransaction = objMethod.getDeclaredAnnotation(RugeTransaction.class);
//        return extTransaction;
//    }
//}
