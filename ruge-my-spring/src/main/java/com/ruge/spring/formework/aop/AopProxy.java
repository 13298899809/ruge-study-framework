package com.ruge.spring.formework.aop;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 20:53
 */
public interface AopProxy {


    Object getProxy();


    Object getProxy(ClassLoader classLoader);
}
