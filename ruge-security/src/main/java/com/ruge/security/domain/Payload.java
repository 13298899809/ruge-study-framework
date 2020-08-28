package com.ruge.security.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName Payload
 * @date 2020.07.21 10:37
 */
@Data
public class Payload<T> {
    private String id;
    private T userInfo;
    private Date expiration;
}
