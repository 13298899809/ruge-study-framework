package com.ruge.tx;

import com.ruge.service.TxPropagationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 事务传播行为
 * @date 2020/6/22 12:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TxPropagationTest {
    @Resource
    private TxPropagationService txPropagationService;

    /**
     * 死活不要事务~~~~工作中基本不会用到~~~~
     * <p>
     * Propagation.NEVER
     * <p>
     * 以非事务方式运行，如果当前存在事务，则抛出异常，即父级方法必须无事务
     */
    @Test
    public void testPropagation1() {
        txPropagationService.dage1();
    }

    /**
     * 死活不要事务~~~~工作中基本不会用到~~~~
     * <p>
     * NOT_SUPPORTED
     * <p>
     * 以非事务方式运行
     * 如果当前存在事务，则把当前事务挂起
     * <p>
     * 如果操作同一张表  会出现死锁
     * 解决建议:不要使用同一张表
     */
    @Test
    public void testPropagation2() {
        txPropagationService.dage2();
    }

    /**
     * SUPPORTS
     * <p>
     * 老大有事务就用，没有就不用
     * <p>
     * 如果当前存在事务，则加入事务
     * 如果当前不存在事务，则以非事务方式运行，这个和不写没区别
     */
    @Test
    public void testPropagation3() {
        txPropagationService.dage3();
    }

    /**
     * REQUIRES_NEW
     * <p>
     * 新建事务，如果当前存在事务，则把当前事务挂起
     * 这个方法会独立提交事务，不受调用者的事务影响，父级异常，它也是正常提交
     * <p>
     * 父子事务独立运行 互不影响
     */
    @Test
    public void testPropagation4() {
        txPropagationService.dage4();
    }

    /**
     * NESTED
     * <p>
     * 如果当前存在事务，它将会成为父级事务的一个子事务，方法结束后并没有提交，只有等父事务结束才提交
     * 如果当前没有事务，则新建事务
     * 如果它异常，父级可以捕获它的异常而不进行回滚，正常提交
     * 但如果父级异常，它必然回滚，这就是和 REQUIRES_NEW 的区别
     */
    @Test
    public void testPropagation5() {
        txPropagationService.dage5();
    }
}
