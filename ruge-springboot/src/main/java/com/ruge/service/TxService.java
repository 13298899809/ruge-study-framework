package com.ruge.service;

import com.ruge.entity.BootUser;
import com.ruge.framework.annotation.RugeTransaction;
import com.ruge.repository.BootUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/20 19:46
 */
@Service
public class TxService {
    @Resource
    private BootUserRepository bootUserRepository;

    /**
     * 初始化数据
     */
    public void save() {
        BootUser bootUser = new BootUser();
        bootUser.setName("圆圆");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
        bootUser = new BootUser();
        bootUser.setName("圈圈");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
    }

    /**
     * 转账正常情况
     * <p>
     * 无事务
     */
    public void transferNormalNoTx() {
        bootUserRepository.findByName("圆圆").ifPresent(e -> {
            e.setMoney(e.getMoney() - 100);
            bootUserRepository.save(e);
        });

        bootUserRepository.findByName("圈圈").ifPresent(e -> {
            e.setMoney(e.getMoney() + 100);
            bootUserRepository.save(e);
        });
    }

    /**
     * 转账异常
     * <p>
     * 无事务
     */
    public void transferAbnormalNoTx() {
        bootUserRepository.findByName("圆圆").ifPresent(e -> {
            e.setMoney(e.getMoney() - 100);
            bootUserRepository.save(e);
        });
        int i = 2 / 0;
        bootUserRepository.findByName("圈圈").ifPresent(e -> {
            e.setMoney(e.getMoney() + 100);
            bootUserRepository.save(e);
        });
    }

    /**
     * 转账正常
     * <p>
     * 使用spring事务
     */
    @Transactional
    public void transferNormalWithSpringTx() {
        bootUserRepository.findByName("圆圆").ifPresent(e -> {
            e.setMoney(e.getMoney() - 100);
            bootUserRepository.save(e);
        });

        bootUserRepository.findByName("圈圈").ifPresent(e -> {
            e.setMoney(e.getMoney() + 100);
            bootUserRepository.save(e);
        });
    }

    /**
     * 转账异常
     * <p>
     * spring事务
     */
    @Transactional
    public void transferAbnormalWithSpringTx() {
        bootUserRepository.findByName("圆圆").ifPresent(e -> {
            e.setMoney(e.getMoney() - 100);
            bootUserRepository.save(e);
        });
        int i = 2 / 0;
        bootUserRepository.findByName("圈圈").ifPresent(e -> {
            e.setMoney(e.getMoney() + 100);
            bootUserRepository.save(e);
        });
    }



    @RugeTransaction
    public void saveWithRugeTx() {
        BootUser bootUser = new BootUser();
        bootUser.setName("张" + UUID.randomUUID());
        bootUserRepository.save(bootUser);
        int i = 1 / 0;
        bootUser.setName("张" + UUID.randomUUID());
        bootUserRepository.save(bootUser);
    }


    public List<BootUser> list() {
        List<BootUser> all = bootUserRepository.findAll();
        return all;
    }
}
