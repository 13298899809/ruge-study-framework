package com.ruge.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName UserService
 * @date 2020.07.03 11:16
 */
@Service
public interface UserService extends UserDetailsService {

}
