package com.ruge.spring.demo.service.impl;

import com.ruge.spring.demo.service.IQueryService;
import com.ruge.spring.formework.annotion.Service;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 22:00
 */
@Slf4j
@Service
public class QueryServiceImpl implements IQueryService {

    /**
     * 查询
     *
     * @param name 姓名
     * @return 返回json数据
     */
    @Override
    public String query(String name) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        String json = "{name:\"" + name + "\",time:\"" + time + "\"}";
        log.info("这是在业务方法中打印的：" + json);
        return json;
    }

}
