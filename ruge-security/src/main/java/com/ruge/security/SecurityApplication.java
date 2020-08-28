package com.ruge.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 启动类
 * @date 2020/6/8 22:12
 */
public class SecurityApplication {
    public static void main(String[] args) {
        Map n = new HashMap();
        n.put("code",1);
        System.out.println(isKSSBlack(n));
    }


    public static Boolean isKSSBlack(Map map) {
        return map == null || !"10000".equals(map.get("code"));
    }
}
