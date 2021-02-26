package com.ruge.framework.tx;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 事务工具类
 * @date 2020/6/21 12:44
 * <p>
 * 每个事务都是新的实例 目的解决线程安全问题 多例子
 * @Scope("prototype")
 */
@Component

@Scope("prototype")
public class TransactionUtils {

    /**
     * 全局接受事务状态
     */
    private TransactionStatus transactionStatus;
    @Resource
    private PlatformTransactionManager platformTransactionManager;

    @Resource
    private TransactionDefinition transactionDefinition;

    /**
     * 开启事务
     *
     * @return 事务状态
     */
    public TransactionStatus begin() {
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        return transactionStatus;
    }

    /**
     * 提交事务
     *
     * @param transactionStatus {@link TransactionStatus}
     */
    public void commit(TransactionStatus transactionStatus) {
        platformTransactionManager.commit(transactionStatus);
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        platformTransactionManager.rollback(transactionStatus);
    }
}
