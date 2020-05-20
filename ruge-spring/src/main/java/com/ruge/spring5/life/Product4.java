package com.ruge.spring5.life;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 生命周期 创建完对象后会调用afterPropertiesSet()方法  进行一些初始化操作
 * 生命周期 创建完对象后会调用destroy()方法  进行一些销毁操作
 */
public class Product4 implements InitializingBean, DisposableBean {
    public Product4() {
        System.out.println("Product4 无参构造方法");
    }

    /**
     * Invoked by the containing {@code BeanFactory} after it has set all bean properties
     * and satisfied {@link BeanFactoryAware}, {@code ApplicationContextAware} etc.
     * <p>This method allows the bean instance to perform validation of its overall
     * configuration and final initialization when all bean properties have been set.
     *
     * @throws Exception in the event of misconfiguration (such as failure to set an
     *                   essential property) or if initialization fails for any other reason
     *                   <p>
     *                   创建完对象后会调用该方法  进行一些初始化操作
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product4-->afterPropertiesSet");
    }

    /**
     * Invoked by the containing {@code BeanFactory} on destruction of a bean.
     *
     * @throws Exception in case of shutdown errors. Exceptions will get logged
     *                   but not rethrown to allow other beans to release their resources as well.
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("Product4-->destroy");
    }
}
