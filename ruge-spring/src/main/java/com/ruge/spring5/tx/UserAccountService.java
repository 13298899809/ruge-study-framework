package com.ruge.spring5.tx;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author ruge.wu
 */
public class UserAccountService {
    public static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/spring-tx.xml");
    public static final EntityManagerFactory ENTITYMANAGERFACTORY = (EntityManagerFactory) CONTEXT.getBean("entityManagerFactory");
    public static final EntityManager ENTITYMANAGER = ENTITYMANAGERFACTORY.createEntityManager();

    @Transactional(rollbackFor = Exception.class)
    public void save() {
        UserAccount userAccount = new UserAccount();
        userAccount.setName("张三");
        userAccount.setMoney(123);
        ENTITYMANAGER.persist(userAccount);
        ENTITYMANAGER.flush();
    }
}
