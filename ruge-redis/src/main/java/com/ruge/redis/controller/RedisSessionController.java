package com.ruge.redis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/9/20 21:29
 */
@RestController
public class RedisSessionController {
    @RequestMapping("test")
    public Map<String, Object> map(HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>(16);
        List list = (List) request.getSession().getAttribute("list");
        if (null == list) {
            list = new ArrayList();
            request.getSession().setAttribute("list", list);
        }
        map.put("sessionId", request.getSession().getId());
        map.put("count", list.size());
        return map;
    }
}
