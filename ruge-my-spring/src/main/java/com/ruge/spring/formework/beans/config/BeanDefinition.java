package com.ruge.spring.formework.beans.config;

import lombok.Data;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: Spring容器启动的过程中，会将Bean解析成Spring内部的BeanDefinition结构
 * 保存bean的配置信息
 * @date 2020/6/7 19:39
 */
@Data
public class BeanDefinition {
    private String beanClassName;
    private boolean lazyInit = false;
    private String factoryBeanName;
    private boolean isSingleton = true;
}
