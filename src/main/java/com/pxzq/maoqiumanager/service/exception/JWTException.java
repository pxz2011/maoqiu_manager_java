package com.pxzq.maoqiumanager.service.exception;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/28 20:08:28
 */

public class JWTException extends RuntimeException{
    public JWTException(String message){
        super(message);
    }
}
