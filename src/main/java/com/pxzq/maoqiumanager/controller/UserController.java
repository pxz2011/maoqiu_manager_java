package com.pxzq.maoqiumanager.controller;

import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/22 20:44:06
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public void login(@RequestParam UserInfoEntity userInfoEntity){

    }
}
