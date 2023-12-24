package com.pxzq.maoqiumanager.service.impl;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxzq.maoqiumanager.dao.UserInfoDao;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import com.pxzq.maoqiumanager.service.UserInfoService;
import com.pxzq.maoqiumanager.utils.JWTUtil;
import com.pxzq.maoqiumanager.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 用户信息serviceImpl
 * @date 2023/12/22 19:00:49
 */
@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String userLogin(UserInfoEntity userInfoEntity) {
        //判断
        UserInfoEntity res = userInfoDao.selectUserInfoByUserNameAndPassword(userInfoEntity.getUserName(), SecureUtil.md5(userInfoEntity.getPassWord()));
        log.info(String.valueOf(res));
        if (res != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", res);
            String jwt = JWTUtil.generateToken(map);
            redisUtil.set("jwt_" + res.getUserName(), jwt, JWTUtil.EXPIRE * 1000);
            return jwt;
        }
        return null;

    }

    @Override
    public String userSignup(UserInfoEntity userInfoEntity) {
        UserInfoEntity userInfoEntity1 = userInfoDao.selectUserInfoByUserName(userInfoEntity.getUserName());
        if (userInfoEntity1 != null) {
            return "用户已存在";
        }
        //password 处理
        String newPassword = SecureUtil.md5(userInfoEntity.getPassWord());
        userInfoEntity.setPassWord(newPassword);
        userInfoEntity.setUserPermission(1);
        userInfoDao.insert(userInfoEntity);
        Map<String, Object> map = new HashMap<>();
        map.put("user", userInfoEntity);
        String jwt = JWTUtil.generateToken(map);
        redisUtil.set("jwt_" + userInfoEntity.getUserName(), jwt, JWTUtil.EXPIRE * 1000);
        return jwt;
    }
}
