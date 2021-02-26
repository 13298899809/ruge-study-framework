package com.ruge.spring5.tx;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.*;
import java.util.List;


/**
 * @author ruge.wu
 */
public class TestTx {

    public static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/spring-tx.xml");
    public static final UserAccountService USERACCOUNTSERVICE = (UserAccountService) CONTEXT.getBean("accountService");

    @Test
    public void test() {
        USERACCOUNTSERVICE.save();
    }


    @Test
    public void testInsert() {
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) CONTEXT.getBean("entityManagerFactory");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        UserAccount userAccount = new UserAccount();
        userAccount.setName("张三");
        userAccount.setMoney(123);
        entityManager.persist(userAccount);
        entityManager.flush();
        transaction.commit();
    }

    @Test
    public void testList() {
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory) CONTEXT.getBean("entityManagerFactory");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query nativeQuery = entityManager.createQuery("select t from UserAccount t");
        List resultList = nativeQuery.getResultList();
        resultList.stream().forEach(e -> {
            System.out.println(e);
        });
    }
}
