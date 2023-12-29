package com.pxzq.maoqiumanager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pxzq.maoqiumanager.common.ResultMessage;
import com.pxzq.maoqiumanager.entity.MaoqiuLiveEntity;
import com.pxzq.maoqiumanager.service.MaoqiuLiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/26 20:32:44
 */
@RestController
@RequestMapping("/maoqiu/live")
public class MaoqiuLiveController {
    @Autowired
    private MaoqiuLiveService maoqiuLiveService;
    //生活情况获取
    @GetMapping("/info")
    public ResultMessage getLive(int pageNum, int pageSize, @RequestHeader("Token") String token) {
        //分页查询
        IPage<MaoqiuLiveEntity> liveListPage = maoqiuLiveService.getLiveListPage(pageNum, pageSize,token);
        return ResultMessage.success(liveListPage.getRecords());
    }
}
