package com.ruge.spring.formework.beans.config;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 20:36
 */
public class BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
