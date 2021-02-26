package com.ruge;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruge.entitys.MpUser;
import com.ruge.mapper.MpUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/20 20:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MPUserTest {
    @Resource
    private MpUserMapper mybatisPlusUserMapper;

    /**
     * 保存测试
     */
    @Test
    public void testSave() {
        for (int i = 0; i < 10; i++) {
            MpUser user = new MpUser();
            user.setName("张" + UUID.randomUUID().toString().substring(0, 3));
            user.setAge(1);
            int insert = mybatisPlusUserMapper.insert(user);
            log.info(String.valueOf(insert));
        }
    }

    /**
     * 更新测试
     */
    @Test
    public void testUpdate() {
        MpUser user = new MpUser();
        user.setId(1273881179692630017L);
        user.setName("刘" + UUID.randomUUID().toString().substring(0, 3));
        int update = mybatisPlusUserMapper.updateById(user);
        System.out.println(update);
    }

    /**
     * 条件查询测试
     */
    @Test
    public void testWrapper() {
        LambdaQueryWrapper<MpUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MpUser::getId, 1274334485340164097L);
        List<MpUser> list = mybatisPlusUserMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    /**
     * 乐观锁测试
     */
    @Test
    public void testOptimisticLocker() {
        /*temp1 查询*/
        MpUser mpUser = mybatisPlusUserMapper.selectById(1274323105828524034L);
        /*修改，观察版本号是否变化*/
        mpUser.setAge(18);
        mybatisPlusUserMapper.updateById(mpUser);

    }

    /**
     * 批量查询
     */
    @Test
    public void testSelectBatchIds() {
        List<Long> longs = Collections.singletonList(1274323105828524034L);
        mybatisPlusUserMapper.selectBatchIds(longs).forEach(System.out::println);

    }

    /**
     * 分页测试
     */
    @Test
    public void testPage() {
        Page<MpUser> page = new Page<>(1, 10);
        mybatisPlusUserMapper.selectPage(page, null).getRecords().forEach(System.out::println);
    }

    /**
     * 逻辑删除
     */
    @Test
    public void testDeleted() {
        mybatisPlusUserMapper.deleteById(1274334451236278273L);
    }
}
