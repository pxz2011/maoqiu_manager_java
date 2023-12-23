package com.pxzq.maoqiumanager.utils;

import cn.hutool.jwt.JWT;

import java.util.Date;
import java.util.Map;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/23 09:21:56
 */

public class JWTUtil {
    public static final long EXPIRE = 7 * 24 * 60 * 60;
    public final static String JWT_KEY = "nmsl";
    public static String generateToken(Map<String,Object> payload){
        JWT jwt = JWT.create();
        payload.forEach(jwt::setPayload);
        jwt.setKey(JWT_KEY.getBytes());
        jwt.setExpiresAt(new Date(System.currentTimeMillis() + EXPIRE * 1000));
        return jwt.sign();
    }
}
