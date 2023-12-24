package com.pxzq.maoqiumanager.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pxzq.maoqiumanager.entity.MaoqiuDailyScheduleEntity;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 生活作息dao
 * @date 2023/12/22 18:59:33
 */
@Mapper
public interface MaoqiuDailyScheduleDao extends BaseMapper<MaoqiuDailyScheduleEntity> {
}
