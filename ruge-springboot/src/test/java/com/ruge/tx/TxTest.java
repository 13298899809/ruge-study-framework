package com.ruge.tx;

import com.ruge.service.tx.TxService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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


    @Test
    public void testList() {
        System.out.println(txService.list());
    }

    @Test
    public void testSave() {
        System.out.println(txService.save());
    }
}
