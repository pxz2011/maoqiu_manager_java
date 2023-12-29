package com.pxzq.maoqiumanager.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.alibaba.fastjson2.JSON;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import com.pxzq.maoqiumanager.service.exception.JWTException;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/23 09:21:56
 */
@Slf4j

public class JwtUtil {
    public static final long EXPIRE = 7 * 24 * 60 * 60;
    public final static String JWT_KEY = "nmsl";

    public static String generateToken(Map<String, Object> payload) {
        JWT jwt = JWT.create();
        payload.forEach(jwt::setPayload);
        jwt.setKey(JWT_KEY.getBytes());
        jwt.setExpiresAt(new Date(System.currentTimeMillis() + EXPIRE * 1000));
        return jwt.sign();
    }


    public static Boolean validateToken(String token) {
        if (StringUtils.isBlank(token)) return false;
        try {
            return JWT.of(token).setKey(JWT_KEY.getBytes()).verify();
        } catch (Exception exception) {
            throw new JWTException(exception.getMessage());
        }

    }

    public static UserInfoEntity validateAndGetUserInfo(String token) {
        if (!validateToken(token)) return null;
        try {
            JWT jwt = JWT.of(token);
            log.info(jwt.getPayload("user").toString());
            return JSON.parseObject(jwt.getPayload("user").toString(), UserInfoEntity.class);
        }catch (Exception exception){
            throw new JWTException(exception.getMessage());
        }

    }
}
