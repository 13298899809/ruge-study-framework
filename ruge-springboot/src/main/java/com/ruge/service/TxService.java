package com.ruge.service;

import com.ruge.entity.BootUser;
import com.ruge.framework.annotation.RugeTransaction;
import com.ruge.repository.BootUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public void save() {
        BootUser bootUser = new BootUser();
        bootUser.setName("张" + UUID.randomUUID());
        bootUserRepository.save(bootUser);
        bootUser.setName("张" + UUID.randomUUID());
        bootUserRepository.save(bootUser);
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

    public Map<String, Object> delete(Long id) {
        Map<String, Object> map = new HashMap<>();
        bootUserRepository.deleteById(id);
        map.put("delete", "success");
        return map;
    }

    public List<BootUser> list() {
        List<BootUser> all = bootUserRepository.findAll();
        return all;
    }
}
