package com.ruge.spring.formework.aop.aspect;

import com.ruge.spring.formework.aop.intercept.MethodInterceptor;
import com.ruge.spring.formework.aop.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 20:50
 */
public class AfterThrowingAdviceInterceptor extends AbstractAspectAdvice implements Advice, MethodInterceptor {


    private String throwingName;

    public AfterThrowingAdviceInterceptor(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        }catch (Throwable e){
            invokeAdviceMethod(mi,null,e.getCause());
            throw e;
        }
    }

    public void setThrowName(String throwName){
        this.throwingName = throwName;
    }
}
