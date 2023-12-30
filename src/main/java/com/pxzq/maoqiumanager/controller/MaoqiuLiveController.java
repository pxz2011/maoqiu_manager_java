package com.pxzq.maoqiumanager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pxzq.maoqiumanager.common.ResultMessage;
import com.pxzq.maoqiumanager.dto.MaoqiuLiveDto;
import com.pxzq.maoqiumanager.entity.MaoqiuLiveEntity;
import com.pxzq.maoqiumanager.service.MaoqiuLiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.pxzq.maoqiumanager.common.ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST;

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
        MaoqiuLiveDto liveListPage = maoqiuLiveService.getLiveListPage(pageNum, pageSize,token);
        return ResultMessage.success(liveListPage);
    }

    //删除
    @DeleteMapping("/{id}")
    public ResultMessage delLive(@PathVariable Long id){
        boolean b = maoqiuLiveService.delLiveInfo(id);
        if (b){
            return ResultMessage.success();
        }
        return ResultMessage.failure(SPECIFIED_QUESTIONED_USER_NOT_EXIST);
    }

    //新增或保存

    @PostMapping("/save")
    public ResultMessage save(@RequestBody MaoqiuLiveEntity entity){
        maoqiuLiveService.saveWithUserId(entity);
        return ResultMessage.success();
    }
}
