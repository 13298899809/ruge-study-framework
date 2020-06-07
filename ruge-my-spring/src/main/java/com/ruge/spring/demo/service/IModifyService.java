package com.ruge.spring.demo.service;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 21:59
 */
public interface IModifyService {
    /**
     * 增加
     */
    public String add(String name, String addr) throws Exception;

    /**
     * 修改
     */
    public String edit(Integer id, String name);

    /**
     * 删除
     */
    public String remove(Integer id);
}
