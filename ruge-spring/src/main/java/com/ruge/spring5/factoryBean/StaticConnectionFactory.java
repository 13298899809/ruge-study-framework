package com.ruge.spring5.factoryBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 静态工厂
 * @author ruge.wu
 */
public class StaticConnectionFactory {

    public static final String IP = "172.20.2.123";
    public static final String PORT = "3306";
    public static final String USERNAME = "arcfox";
    public static final String PASSWORD = "TIMA_arcfox_2019";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" + IP + ":" + PORT + "/RUGE", USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }


}
