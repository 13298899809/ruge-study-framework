package com.ruge.spring.formework.aop.aspect;


import com.ruge.spring.formework.aop.intercept.MethodInterceptor;
import com.ruge.spring.formework.aop.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 20:43
 */
public class AfterReturningAdviceInterceptor extends AbstractAspectAdvice implements Advice, MethodInterceptor {

    private JoinPoint joinPoint;

    public AfterReturningAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object retVal = mi.proceed();
        this.joinPoint = mi;
        this.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
        return retVal;
    }

    private void afterReturning(Object retVal, Method method, Object[] arguments, Object aThis) throws Throwable {
        super.invokeAdviceMethod(this.joinPoint, retVal, null);
    }
}
