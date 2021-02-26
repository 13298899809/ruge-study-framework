package com.ruge.spring.demo.service;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 21:59
 */
public interface IQueryService {

    /**
     * 查询
     *
     * @param name 姓名
     * @return 返回json数据
     */
    String query(String name);
}
