package com.ruge.druid.controller;

import com.ruge.druid.entitys.DruidUser;
import com.ruge.druid.repository.DruidUserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName DruidUserController
 * @date 2020.07.02 11:15
 */
@RestController
public class DruidUserController {
    @Resource
    private DruidUserRepository druidUserRepository;

    @GetMapping("list")
    public Map<String, Object> list() {
        Map<String, Object> map = new HashMap<>(16);
        List<DruidUser> all = druidUserRepository.findAll();
        map.put("all", all);
        return map;
    }
}
