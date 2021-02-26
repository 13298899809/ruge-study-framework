package com.ruge.service;

import com.ruge.entity.BootUser;
import com.ruge.repository.BootUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 事务传播行为
 * @date 2020/6/22 12:56
 */
@Service
public class TxPropagationService {
    @Resource
    private BootUserRepository bootUserRepository;

    /**
     * 场景一： serviceA 方法调用了 serviceB 方法，但两个方法都有事务，这个时候如果 serviceB 方法异常，是让 serviceB 方法提交，还是两个一起回滚。
     */

    /**
     * 场景二：serviceA 方法调用了 serviceB 方法，但是只有 serviceA 方法加了事务，是否把 serviceB 也加入 serviceA 的事务，如果 serviceB 异常，是否回滚 serviceA 。
     */

    /**
     * 场景三：serviceA 方法调用了 serviceB 方法，两者都有事务，serviceB 已经正常执行完，但 serviceA 异常，是否需要回滚 serviceB 的数据。
     */
    public void dage1() {
        BootUser bootUser = new BootUser();
        bootUser.setName("大哥1");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
        xiaodi1();
        int i = 2 / 0;
    }

    /**
     * propagation = Propagation.NEVER
     * <p>
     * 以非事务方式运行，如果当前存在事务，则抛出异常，即父级方法必须无事务
     */
    @Transactional(propagation = Propagation.NEVER,rollbackFor = Exception.class)
    public void xiaodi1() {
        BootUser bootUser = new BootUser();
        bootUser.setName("小弟1");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
        int i = 2 / 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void dage2() {
        BootUser bootUser = new BootUser();
        bootUser.setName("大哥2");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
        xiaodi2();
        int i = 2 / 0;
    }

    /**
     * NOT_SUPPORTED
     * <p>
     * 以非事务方式运行
     * 如果当前存在事务，则把当前事务挂起
     * <p>
     * 如果操作同一张表  会出现死锁
     * 解决建议:不要使用同一张表
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void xiaodi2() {
        BootUser bootUser = new BootUser();
        bootUser.setName("小弟2");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
        int i = 2 / 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void dage3() {
        BootUser bootUser = new BootUser();
        bootUser.setName("大哥3");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
        xiaodi3();
    }

    /**
     * SUPPORTS
     * <p>
     * 老大有事务就用，没有就不用
     * <p>
     * 如果当前存在事务，则加入事务
     * 如果当前不存在事务，则以非事务方式运行，这个和不写没区别
     */
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public void xiaodi3() {
        BootUser bootUser = new BootUser();
        bootUser.setName("小弟3");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
        int i = 2 / 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void dage4() {
        // 暂时将 代码注释 避免由于失误挂起导致的锁死
        xiaodi4();
        int i = 2 / 0;
    }

    /**
     * REQUIRES_NEW
     * <p>
     * 新建事务，如果当前存在事务，则把当前事务挂起
     * 这个方法会独立提交事务，不受调用者的事务影响，父级异常，它也是正常提交
     * <p>
     * 父子事务独立运行 互不影响
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public void xiaodi4() {
        BootUser bootUser = new BootUser();
        bootUser.setName("小弟4");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
    }


    @Transactional(rollbackFor = Exception.class)
    public void dage5() {
        BootUser bootUser = new BootUser();
        bootUser.setName("大哥5");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
        xiaodi5();

    }

    /**
     * NESTED
     * <p>
     * 如果当前存在事务，它将会成为父级事务的一个子事务，方法结束后并没有提交，只有等父事务结束才提交
     * 如果当前没有事务，则新建事务
     * 如果它异常，父级可以捕获它的异常而不进行回滚，正常提交
     * 但如果父级异常，它必然回滚，这就是和 REQUIRES_NEW 的区别
     */
    @Transactional(propagation = Propagation.NESTED,rollbackFor = Exception.class)
    public void xiaodi5() {
        BootUser bootUser = new BootUser();
        bootUser.setName("小弟5");
        bootUser.setMoney(1000);
        bootUserRepository.save(bootUser);
        int i = 2 / 0;
    }
}
