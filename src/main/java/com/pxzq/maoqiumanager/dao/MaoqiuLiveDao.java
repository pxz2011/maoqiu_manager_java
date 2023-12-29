package com.pxzq.maoqiumanager.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pxzq.maoqiumanager.entity.MaoqiuLiveEntity;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description 生活信息dao
 * @date 2023/12/22 18:58:22
 */
@Mapper
public interface MaoqiuLiveDao extends BaseMapper<MaoqiuLiveEntity> {
}
