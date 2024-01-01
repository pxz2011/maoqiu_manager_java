package com.pxzq.maoqiumanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxzq.maoqiumanager.dto.MaoqiuDietEntityDto;
import com.pxzq.maoqiumanager.entity.MaoqiuDietEntity;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 饮食信息service
 * @date 2023/12/22 19:01:34
 */

public interface MaoqiuDietService extends IService<MaoqiuDietEntity> {
    MaoqiuDietEntityDto getDietListPage(int pageNum, int pageSize, String token);

    boolean delDietInfo(Long id);
}
