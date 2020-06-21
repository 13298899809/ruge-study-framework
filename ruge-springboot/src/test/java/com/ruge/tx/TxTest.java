package com.ruge.tx;

import com.ruge.framework.aop.AopTransaction;
import com.ruge.framework.tx.TransactionUtils;
import com.ruge.service.TxService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.TransactionStatus;

import javax.annotation.Resource;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/20 19:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TxTest {
    @Resource
    private TxService txService;
    @Resource
    private TransactionUtils transactionUtils;

    /**
     * 数据查询
     */
    @Test
    public void testList() {
        txService.list().forEach(System.out::println);
    }

    /**
     * 数据保存测试
     */
    @Test
    public void testSave() {
        txService.save();
    }

    /**
     * 不使用事务
     * 默认情况 只增加了一条数据
     */
    @Test
    public void testNoTx() {
        txService.save();
        int i = 1 / 0;
        txService.save();
    }

    /**
     * 带事务的测试
     * 需要将 {@link AopTransaction} 进行注释
     */
    @Test
    public void testWithTx() {
        TransactionStatus status = transactionUtils.begin();
        try {
            txService.save();
            int i = 1 / 0;
            txService.save();
            transactionUtils.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            transactionUtils.rollback();
        }
    }

    /**
     * aop事务
     * 需要保留 {@link AopTransaction}
     */
    @Test
    public void testWithAopTx() {
        txService.save();
    }

    /**
     * 使用自定义注解实现事务
     */
    @Test
    public void testWithRugeTx() {
        txService.saveWithRugeTx();
    }
}
