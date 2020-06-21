package com.ruge.service.tx;

import com.ruge.entity.BootUser;
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

    public Map<String, Object> save() {
        Map<String, Object> map = new HashMap<>();
        BootUser bootUser = new BootUser();
        bootUser.setName("张" + UUID.randomUUID());
        BootUser save = bootUserRepository.save(bootUser);
        map.put("save", save);
        return map;
    }

    public Map<String, Object> delete(Long id) {
        Map<String, Object> map = new HashMap<>();
        bootUserRepository.deleteById(id);
        map.put("delete", "success");
        return map;
    }

    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>();
        List<BootUser> all = bootUserRepository.findAll();
        map.put("list", all);
        return map;
    }
}
