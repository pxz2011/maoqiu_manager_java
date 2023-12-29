package com.pxzq.maoqiumanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxzq.maoqiumanager.dao.MaoqiuLiveDao;
import com.pxzq.maoqiumanager.entity.MaoqiuLiveEntity;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import com.pxzq.maoqiumanager.service.MaoqiuLiveService;
import com.pxzq.maoqiumanager.service.exception.JWTException;
import com.pxzq.maoqiumanager.utils.JwtUtil;
import org.springframework.stereotype.Service;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/22 19:04:29
 */
@Service

public class MaoqiuLiveServiceImpl extends ServiceImpl<MaoqiuLiveDao, MaoqiuLiveEntity> implements MaoqiuLiveService {
    @Override
    public IPage<MaoqiuLiveEntity> getLiveListPage(int pageNum, int pageSize, String token) {
        Page<MaoqiuLiveEntity> page = new Page<>(pageNum, pageSize);
        UserInfoEntity userInfoEntity = JwtUtil.validateAndGetUserInfo(token);
        if (userInfoEntity != null) {
            return this.page(page,new LambdaQueryWrapper<MaoqiuLiveEntity>().eq(MaoqiuLiveEntity::getUserId,userInfoEntity.getId()));
        }
        throw new JWTException("jwt有误");
    }

    @Override
    public boolean delLiveInfo(Long id) {
        return this.removeById(id);
    }
}
