package com.ruge.validator;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 班级
 * @date 2021/1/25 23:21
 */
@Data
public class Grade {
    /*班级号*/
    @NotNull(message = "班号不能为空")
    private Integer id;
}
