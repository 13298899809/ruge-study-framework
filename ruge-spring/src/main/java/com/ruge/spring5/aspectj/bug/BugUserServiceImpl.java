package com.ruge.spring5.aspectj.bug;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;

/**
 * 同一个业务类中，进行业务方法间的相互调用，只有最外层方法才是加入了额外功能的
 * 内部的方法 通过普通方法调用的话 都调用的是原始方法
 * @author ruge.wu
 */
public class BugUserServiceImpl implements BugUserService, ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 用户注册
     *
     * @param userName 用户名
     * @param passWord 密码
     */
    @Override
    public void register(String userName, String passWord) {
        System.out.println("bug aspectj 用户注册 -->" + userName + "," + passWord);
        BugUserServiceImpl userServiceBug = (BugUserServiceImpl) applicationContext.getBean("userService_bug");
        userServiceBug.login(userName, passWord);
    }

    /**
     * 用户登陆
     *
     * @param userName 用户名
     * @param passWord 密码
     */
    @Override
    public void login(String userName, String passWord) {
        System.out.println("bug aspectj 用户登陆 -->" + userName + "," + passWord);
    }

    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     * <p>Invoked after population of normal bean properties but before an init callback such
     * as {@link InitializingBean#afterPropertiesSet()}
     * or a custom init-method. Invoked after {@link ResourceLoaderAware#setResourceLoader},
     * {@link ApplicationEventPublisherAware#setApplicationEventPublisher} and
     * {@link MessageSourceAware}, if applicable.
     *
     * @param applicationContext the ApplicationContext object to be used by this object
     * @throws ApplicationContextException in case of context initialization errors
     * @throws BeansException              if thrown by application context methods
     * @see BeanInitializationException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}