package com.ruge.spring.formework.context.support;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: IOC容器实现的顶层设计
 * @date 2020/6/7 19:54
 */
public abstract class AbstractApplicationContext {
    /**
     * 受保护，只提供给子类重写
     * @throws Exception
     */
    public void refresh() throws Exception {
    }
}
