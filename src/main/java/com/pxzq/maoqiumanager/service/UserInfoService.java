package com.pxzq.maoqiumanager.service;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 用户信息service
 * @date 2023/12/22 19:00:16
 */

public interface UserInfoService extends IService<UserInfoEntity> {
    String userLogin(UserInfoEntity userInfoEntity);

    String userSignup(UserInfoEntity userInfoEntity);
}