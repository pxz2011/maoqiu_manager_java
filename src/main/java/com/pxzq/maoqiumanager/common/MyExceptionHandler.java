package com.pxzq.maoqiumanager.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/24 08:54:45
 */
@ControllerAdvice
@RestController
@Slf4j
public class MyExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultMessage handleException(Exception ex){
        String msg = ex.getMessage();
        log.error(msg);
        return ResultMessage.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
    }
}
