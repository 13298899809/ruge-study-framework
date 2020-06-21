package com.ruge.entitys;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.time.LocalDateTime;

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
    /*自动填充功能*/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /*自动填充功能*/
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    /*乐观锁*/
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    /*逻辑删除*/
    @TableLogic
    private boolean deleted;
}
