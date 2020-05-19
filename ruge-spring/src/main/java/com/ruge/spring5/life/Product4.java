package com.ruge.spring5.life;

import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;

public class Product4 implements InitializingBean {
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
}
