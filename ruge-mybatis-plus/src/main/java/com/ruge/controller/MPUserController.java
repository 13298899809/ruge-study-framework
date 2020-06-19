package com.ruge.controller;

import com.ruge.entitys.MPUser;
import com.ruge.mapper.MPUserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName MybatisPlusUserController
 * @date 2020.06.19 15:23
 */
@RestController
public class MPUserController {
    @Resource
    private MPUserMapper mybatisPlusUserMapper;

    @PostMapping("save")
    public Map<String, Object> save() {
        Map map = new HashMap();
        MPUser user = new MPUser();
        user.setName("张" + UUID.randomUUID().toString().substring(0, 3));
        user.setAge(1);
        int insert = mybatisPlusUserMapper.insert(user);
        map.put("insert", insert);
        return map;
    }

    @GetMapping("list")
    public Map<String, Object> list() {
        Map map = new HashMap();
        List<MPUser> list = mybatisPlusUserMapper.selectList(null);
        map.put("list", list);
        return map;
    }
}
