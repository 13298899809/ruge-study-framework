package com.ruge.spring5.aop;

import org.springframework.beans.factory.BeanFactory;

public class UserServiceImpl implements UserService {


    /**
     * 用户注册
     *
     * @param userName 用户名
     * @param passWord 密码
     */
    @Log
    @Override
    public void register(String userName, String passWord) {
        System.out.println("用户注册 -->" + userName + "," + passWord);
    }

    /**
     * 用户登陆
     *
     * @param userName 用户名
     * @param passWord 密码
     */
    @Override
    public void login(String userName, String passWord) {
        System.out.println("用户登陆 -->" + userName + "," + passWord);
    }
}
