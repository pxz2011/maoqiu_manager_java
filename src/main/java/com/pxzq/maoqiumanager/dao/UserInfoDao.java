package com.pxzq.maoqiumanager.dao;

import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 用户信息dao
 * @date 2023/12/22 18:56:25
 */
@Mapper
public interface UserInfoDao {
    void insertUserInfo(UserInfoEntity userInfoEntity);

    UserInfoEntity selectUserInfoById(Long id);

    void deleteUserInfo(Long id);
}
