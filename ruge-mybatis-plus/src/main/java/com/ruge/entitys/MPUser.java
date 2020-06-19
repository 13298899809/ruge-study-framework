package com.ruge.entitys;

import lombok.Data;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName User
 * @date 2020.06.19 15:03
 */
@Data
public class MPUser {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
