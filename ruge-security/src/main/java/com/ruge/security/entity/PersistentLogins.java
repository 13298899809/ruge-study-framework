package com.ruge.security.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName PersistentLogins
 * @date 2020.07.15 10:53
 */
@Data
@Entity
public class PersistentLogins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String series;
    private String token;
    private String last_used;
}
