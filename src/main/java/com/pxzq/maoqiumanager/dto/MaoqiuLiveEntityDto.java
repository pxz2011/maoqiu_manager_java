package com.pxzq.maoqiumanager.dto;

import com.pxzq.maoqiumanager.entity.MaoqiuLiveEntity;
import lombok.Data;

import java.util.List;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/30 08:10:28
 */
@Data
public class MaoqiuLiveEntityDto {
    private List<MaoqiuLiveEntity> maoqiuLiveEntities;
    private Long total;
}
