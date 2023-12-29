package com.pxzq.maoqiumanager.mapper;

import com.pxzq.maoqiumanager.dao.UserInfoDao;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/22 19:18:25
 */
@SpringBootTest
public class UserInfoMapperTest {
    @Autowired
    private UserInfoDao userInfoMapper;
    @Test
    void test01(){
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUserName("test");
        userInfoEntity.setUserPermission(0);
        userInfoEntity.setCreateTime(new Date());
        userInfoEntity.setUpdateTime(new Date());
        userInfoEntity.setEmail("test");
        userInfoEntity.setPassWord("test");
        this.userInfoMapper.insertUserInfo(userInfoEntity);
    }
    @Test
    void test02(){
        Long l = Long.parseLong("3");
        UserInfoEntity userInfoEntity = this.userInfoMapper.selectUserInfoById(l);
        System.out.println("userInfoEntity = " + userInfoEntity);
    }
    @Test
    void test03(){
        Long l = Long.parseLong("6");
        this.userInfoMapper.deleteUserInfo(l);
    }
}
