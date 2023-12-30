package com.pxzq.maoqiumanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxzq.maoqiumanager.dto.MaoqiuLiveDto;
import com.pxzq.maoqiumanager.entity.MaoqiuLiveEntity;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/22 19:04:07
 */

public interface MaoqiuLiveService extends IService<MaoqiuLiveEntity> {
    MaoqiuLiveDto getLiveListPage(int pageNum, int pageSize, String token);

    boolean delLiveInfo(Long id);

    void saveWithUserId(MaoqiuLiveEntity entity);
}
