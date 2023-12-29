package com.pxzq.maoqiumanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;

import java.util.Map;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 用户信息service
 * @date 2023/12/22 19:00:16
 */

public interface UserInfoService extends IService<UserInfoEntity> {
    Map<String, Object> userLogin(UserInfoEntity userInfoEntity);

    String userSignup(UserInfoEntity userInfoEntity);
}