package com.pxzq.maoqiumanager.service;

import com.pxzq.maoqiumanager.entity.UserInfoEntity;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 用户信息service
 * @date 2023/12/22 19:00:16
 */

public interface UserInfoService {
    String userLogin(UserInfoEntity userInfoEntity);
}