package com.pxzq.maoqiumanager.service.impl;

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
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public String userLogin(UserInfoEntity userInfoEntity) {
        //判断
        UserInfoEntity res = userInfoDao.selectUserInfoByUserNameAndPassword(userInfoEntity.getUserName(), userInfoEntity.getPassWord());
        log.info(String.valueOf(res));
        if(res != null){
            Map<String, Object> map = new HashMap<>();
            map.put("user",res);
            String jwt = JWTUtil.generateToken(map);
            redisUtil.set("jwt_"+res.getUserName(),jwt);
            return jwt;
        }
        return null;

    }
}
