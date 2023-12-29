package com.pxzq.maoqiumanager.controller;

import com.pxzq.maoqiumanager.common.ResultCode;
import com.pxzq.maoqiumanager.common.ResultMessage;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import com.pxzq.maoqiumanager.service.UserInfoService;
import com.pxzq.maoqiumanager.utils.JwtUtil;
import com.pxzq.maoqiumanager.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.pxzq.maoqiumanager.common.ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST;


/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/22 20:44:06
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public ResultMessage login(@RequestBody UserInfoEntity userInfoEntity) {
        //1.传给service层
        log.info(userInfoEntity.toString());
        Map<String,Object> res = userInfoService.userLogin(userInfoEntity);
        if (res != null) {
            return ResultMessage.success(res);
        }
        return ResultMessage.failure(ResultCode.USER_LOGIN_ERROR);
    }

    @PostMapping("/signup")
    public ResultMessage signup(@RequestBody UserInfoEntity userInfoEntity) {
        log.info(userInfoEntity.toString());
        String s = userInfoService.userSignup(userInfoEntity);
        return ResultMessage.success(s);
    }

    @PostMapping("/logout")
    public ResultMessage logOut(@RequestParam String token) {
        UserInfoEntity userInfoEntity = JwtUtil.validateAndGetUserInfo(token);
        if (userInfoEntity != null) {
            redisUtil.del("jwt_" + userInfoEntity.getUserName());
            return ResultMessage.success();
        }
        return ResultMessage.failure(SPECIFIED_QUESTIONED_USER_NOT_EXIST);

    }
}