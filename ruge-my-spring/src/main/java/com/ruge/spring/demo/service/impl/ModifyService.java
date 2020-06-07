package com.ruge.spring.demo.service.impl;

import com.ruge.spring.demo.service.IModifyService;
import com.ruge.spring.formework.annotion.Service;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 22:00
 */
@Service
public class ModifyService implements IModifyService {

    /**
     * 增加
     */
    public String add(String name, String addr) throws Exception {
        throw new Exception("这是Ruge故意抛的异常！！");
        //return "modifyService add,name=" + name + ",addr=" + addr;
    }

    /**
     * 修改
     */
    public String edit(Integer id, String name) {
        return "modifyService edit,id=" + id + ",name=" + name;
    }

    /**
     * 删除
     */
    public String remove(Integer id) {
        return "modifyService id=" + id;
    }

}
