package com.ruge.spring.formework.aop;

import com.ruge.spring.formework.aop.support.AdvisedSupport;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 20:53
 */
public class CglibAopProxy implements  AopProxy {
    public CglibAopProxy(AdvisedSupport config) {
    }

    @Override
    public Object getProxy() {
        return null;
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}
