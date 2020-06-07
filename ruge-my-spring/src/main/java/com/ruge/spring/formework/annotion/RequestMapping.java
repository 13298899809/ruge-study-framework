package com.ruge.spring.formework.annotion;

import java.lang.annotation.*;

/**
 * @author 嘿丷如歌
 * @version V1.0
 * @Description:
 * @date 2020/6/7 1:41
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestMapping {
    String value() default "";
}
