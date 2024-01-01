package com.pxzq.maoqiumanager.controller;

import com.pxzq.maoqiumanager.common.ResultMessage;
import com.pxzq.maoqiumanager.dto.MaoqiuDietEntityDto;
import com.pxzq.maoqiumanager.service.MaoqiuDietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.pxzq.maoqiumanager.common.ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/31 08:08:53
 */
@RestController
@RequestMapping("/maoqiu/diet")
public class MaoqiuDietController {
    @Autowired
    private MaoqiuDietService maoqiuDietService;
    @GetMapping("/info")
    public ResultMessage getInfo(int pageNum,int pageSize,@RequestHeader("Token") String token){
        MaoqiuDietEntityDto dietListPage = maoqiuDietService.getDietListPage(pageNum, pageSize, token);
        return ResultMessage.success(dietListPage);
    }

    @DeleteMapping("/{id}")
    public  ResultMessage del(@PathVariable Long id){
        boolean isOk = maoqiuDietService.delDietInfo(id);
        if(isOk) return ResultMessage.success();
        else  return ResultMessage.failure(SPECIFIED_QUESTIONED_USER_NOT_EXIST);
    }
}
