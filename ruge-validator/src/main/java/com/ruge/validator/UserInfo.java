package com.ruge.validator;

import com.ruge.validator.anno.IsMobile;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description: 用户类
 * @date 2021/1/25 21:34
 */
@Data
public class UserInfo {
    public interface Add {
    }

    ;

    public interface Update {
    }

    ;
    /*分组校验*/
    @NotNull(message = "修改数据 id不能为空", groups = Update.class)
    @Null(message = "新增数据 id可以为空", groups = Add.class)
    private Integer id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Min(value = 10, message = "年龄最小为：{value}")
    private int age;
    /*级联校验*/
    @NotNull(message = "班级不能为空")
    @Valid // 级联校验生效注解
    private Grade grade;
    @IsMobile
    private String mobile;
}
