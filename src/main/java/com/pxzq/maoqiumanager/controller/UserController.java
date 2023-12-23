package com.pxzq.maoqiumanager.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.AlgorithmUtil;
import cn.hutool.jwt.signers.JWTSigner;
import com.pxzq.maoqiumanager.common.ResultCode;
import com.pxzq.maoqiumanager.common.ResultMessage;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import com.pxzq.maoqiumanager.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/22 20:44:06
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public ResultMessage login(@RequestBody UserInfoEntity userInfoEntity) {
        //1.传给service层
        log.info(userInfoEntity.toString());
        String res = userInfoService.userLogin(userInfoEntity);
        if (res != null) {
            return ResultMessage.success(res);
        }
        return ResultMessage.failure(ResultCode.USER_LOGIN_ERROR);
    }
}
