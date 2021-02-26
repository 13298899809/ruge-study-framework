package com.ruge.security;

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
        Map n = new HashMap(16);
        n.put("code",1);
        System.out.println(isKssBlack(n));
    }


    public static Boolean isKssBlack(Map map) {
        return map == null || !"10000".equals(map.get("code"));
    }
}
