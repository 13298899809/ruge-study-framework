package com.ruge.security.advice;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ruge.wu
 * @version 0.0.1
 * @ClassName HandlerException
 * @date 2020.07.17 15:17
 */
@ControllerAdvice
public class HandlerException {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handlerException(Exception e) {
        String result = "";
        if (e instanceof AccessDeniedException) {
            result = "您无权访问";
        }
        return result;
    }
}
