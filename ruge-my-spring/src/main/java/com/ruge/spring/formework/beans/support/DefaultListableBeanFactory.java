package com.ruge.spring.formework.beans.support;

import com.ruge.spring.formework.beans.config.BeanDefinition;
import com.ruge.spring.formework.context.support.AbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 19:55
 */
public class DefaultListableBeanFactory extends AbstractApplicationContext {

    /**
     * 存储注册信息的BeanDefinition,伪IOC容器
     */
    protected final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

}
