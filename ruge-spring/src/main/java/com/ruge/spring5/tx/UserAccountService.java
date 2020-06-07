package com.ruge.spring5.tx;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserAccountService {
    public static final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-tx.xml");
    public static final EntityManagerFactory entityManagerFactory = (EntityManagerFactory) context.getBean("entityManagerFactory");
    public static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Transactional
    public void save() {
        UserAccount userAccount = new UserAccount();
        userAccount.setName("张三");
        userAccount.setMoney(123);
        entityManager.persist(userAccount);
        entityManager.flush();
    }
}
