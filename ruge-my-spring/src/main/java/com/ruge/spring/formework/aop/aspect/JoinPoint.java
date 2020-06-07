package com.ruge.spring.formework.aop.aspect;

import java.lang.reflect.Method;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 20:43
 */
public interface JoinPoint {

    Object getThis();

    Object[] getArguments();

    Method getMethod();

    void setUserAttribute(String key, Object value);

    Object getUserAttribute(String key);
}
