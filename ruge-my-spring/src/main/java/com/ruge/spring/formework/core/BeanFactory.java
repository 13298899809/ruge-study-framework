package com.ruge.spring.formework.core;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 单例工厂的顶层设计
 * @date 2020/6/7 19:32
 */
public interface BeanFactory {
    /**
     * Return an instance, which may be shared or independent, of the specified bean.
     * <p>This method allows a Spring BeanFactory to be used as a replacement for the
     * Singleton or Prototype design pattern. Callers may retain references to
     * returned objects in the case of Singleton beans.
     * <p>Translates aliases back to the corresponding canonical bean name.
     * Will ask the parent factory if the bean cannot be found in this factory instance.
     * @return an instance of the bean
     */
    Object getBean(String beanName) throws Exception;

    /**
     * Return the bean instance that uniquely matches the given object type, if any.
     * but may also be translated into a conventional by-name lookup based on the name
     * of the given type. For more extensive retrieval operations across sets of beans,
     * @since 3.0
     */
    Object getBean(Class<?> beanClass) throws Exception;

}
