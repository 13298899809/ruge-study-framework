package com.ruge.security.controller;

import com.ruge.security.repository.UserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 登陆控制器
 * @date 2020/6/9 21:26
 */
@RestController
public class LoginController {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>(16);
        SecurityContext context = SecurityContextHolder.getContext();
        map.put("user1", context);
        map.put("user2", context.getAuthentication());
        map.put("user3", context.getAuthentication().getPrincipal());

        return map;
    }

    @Secured("ROLE_admin")
    @GetMapping("/admin/hello")
    public String admin() {
        return "admin";
    }

    @Secured("ROLE_user")
    @GetMapping("/user/hello")
    public String user() {
        return "user";
    }
}
