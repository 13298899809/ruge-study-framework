package com.ruge.spring5.aspectj.bug;

/**
 * @author ruge.wu
 */
public interface BugUserService {
    /**
     * 用户注册
     *
     * @param userName 用户名
     * @param passWord 密码
     */
    void register(String userName, String passWord);

    /**
     * 用户登陆
     *
     * @param userName 用户名
     * @param passWord 密码
     */
    void login(String userName, String passWord);
}