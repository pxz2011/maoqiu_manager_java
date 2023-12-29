package com.pxzq.maoqiumanager.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 用户信息dao
 * @date 2023/12/22 18:56:25
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
    void insertUserInfo(UserInfoEntity userInfoEntity);

    UserInfoEntity selectUserInfoById(Long id);
    UserInfoEntity selectUserInfoByUserName(@Param("userName") String userName);
    void deleteUserInfo(Long id);

    UserInfoEntity selectUserInfoByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
