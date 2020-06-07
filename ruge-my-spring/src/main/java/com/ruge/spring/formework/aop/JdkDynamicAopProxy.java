package com.ruge.spring.formework.aop;

import com.ruge.spring.formework.aop.intercept.MethodInvocation;
import com.ruge.spring.formework.aop.support.AdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 20:54
 */
public class JdkDynamicAopProxy implements  AopProxy, InvocationHandler {

    private AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport config){
        this.advised = config;
    }

    @Override
    public Object getProxy() {
        return getProxy(this.advised.getTargetClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader,this.advised.getTargetClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> interceptorsAndDynamicMethodMatchers = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method,this.advised.getTargetClass());
        MethodInvocation invocation = new MethodInvocation(proxy,this.advised.getTarget(),method,args,this.advised.getTargetClass(),interceptorsAndDynamicMethodMatchers);
        return invocation.proceed();
    }
}
