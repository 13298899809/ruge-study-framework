package com.ruge.spring5.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author ruge.wu
 */
public class AopAround implements MethodInterceptor {
    /**
     * @param methodInvocation 额外功能所增加给的原始方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("@log 注解拦截 方法运行之前~~~~~~~~~");
        /*运行原始方法*/
        Object proceed = null;
        try {
            proceed = methodInvocation.proceed();
        } catch (Throwable throwable) {
            System.out.println("@log 注解拦截 方法运行异常~~~~~~~~~");
            throwable.printStackTrace();
        }
        System.out.println("@log 注解拦截 方法运行之后~~~~~~~~~");
        return proceed;
    }
}
