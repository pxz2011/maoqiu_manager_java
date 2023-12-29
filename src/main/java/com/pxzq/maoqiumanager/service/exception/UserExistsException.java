package com.pxzq.maoqiumanager.service.exception;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/24 14:41:41
 */

public class UserExistsException extends RuntimeException {
    public UserExistsException(String msg){
        super(msg);
    }
}
