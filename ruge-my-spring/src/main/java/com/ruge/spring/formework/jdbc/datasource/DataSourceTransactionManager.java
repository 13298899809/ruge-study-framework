package com.ruge.spring.formework.jdbc.datasource;

import javax.sql.DataSource;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 21:03
 */
public class DataSourceTransactionManager {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}

