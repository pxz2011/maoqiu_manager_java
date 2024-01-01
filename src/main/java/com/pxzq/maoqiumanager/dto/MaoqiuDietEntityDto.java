package com.pxzq.maoqiumanager.dto;

import com.pxzq.maoqiumanager.entity.MaoqiuDietEntity;
import lombok.Data;

import java.util.List;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/31 08:15:26
 */
@Data
public class MaoqiuDietEntityDto {
    private List<MaoqiuDietEntity> entities;

    private Long total;
}
