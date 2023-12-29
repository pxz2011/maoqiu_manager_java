package com.pxzq.maoqiumanager.common;

import com.pxzq.maoqiumanager.service.exception.JWTException;
import com.pxzq.maoqiumanager.service.exception.UserExistsException;
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
        ex.printStackTrace();
        return ResultMessage.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
    }

    @ExceptionHandler(UserExistsException.class)
    public ResultMessage handleUserExists(UserExistsException ex){
        ex.printStackTrace();
        return ResultMessage.failure(ResultCode.USER_HAS_EXISTED);
    }

    @ExceptionHandler(JWTException.class)
    public ResultMessage handleJwtException(JWTException ex){
        ex.printStackTrace();
        return ResultMessage.failure(ResultCode.PERMISSION_NO_ACCESS);
    }
}
