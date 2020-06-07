package com.ruge.spring.formework.aop.intercept;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 20:46
 */
public interface MethodInterceptor {
    Object invoke(MethodInvocation invocation) throws Throwable;

}
