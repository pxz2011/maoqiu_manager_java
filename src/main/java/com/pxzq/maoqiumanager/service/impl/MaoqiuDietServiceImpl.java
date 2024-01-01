package com.pxzq.maoqiumanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pxzq.maoqiumanager.dao.MaoqiuDietDao;
import com.pxzq.maoqiumanager.dto.MaoqiuDietEntityDto;
import com.pxzq.maoqiumanager.entity.MaoqiuDietEntity;
import com.pxzq.maoqiumanager.entity.MaoqiuLiveEntity;
import com.pxzq.maoqiumanager.entity.UserInfoEntity;
import com.pxzq.maoqiumanager.service.MaoqiuDietService;
import com.pxzq.maoqiumanager.service.exception.JWTException;
import com.pxzq.maoqiumanager.utils.JwtUtil;
import org.springframework.stereotype.Service;

/**
 * @author pxz
 * @version 1.0
 * @project maoqiu-manager
 * @description
 * @date 2023/12/22 19:02:13
 */
@Service
public class MaoqiuDietServiceImpl extends ServiceImpl<MaoqiuDietDao,MaoqiuDietEntity> implements MaoqiuDietService {
    @Override
    public MaoqiuDietEntityDto getDietListPage(int pageNum, int pageSize, String token) {
        Page<MaoqiuDietEntity> page = new Page<>(pageNum, pageSize);
        UserInfoEntity userInfoEntity = JwtUtil.validateAndGetUserInfo(token);
        if (userInfoEntity != null) {
            MaoqiuDietEntityDto maoqiuDietDto = new MaoqiuDietEntityDto();
            LambdaQueryWrapper<MaoqiuDietEntity> maoqiuDietEntityLambdaQueryWrapper = new LambdaQueryWrapper<>();
            maoqiuDietEntityLambdaQueryWrapper.eq(MaoqiuDietEntity::getUserId,userInfoEntity.getId());
            maoqiuDietEntityLambdaQueryWrapper.orderByDesc(MaoqiuDietEntity::getDate);
            Page<MaoqiuDietEntity> page1 = this.page(page, maoqiuDietEntityLambdaQueryWrapper);
            maoqiuDietDto.setEntities(page1.getRecords());
            maoqiuDietDto.setTotal(this.count(new LambdaQueryWrapper<MaoqiuDietEntity>().eq(MaoqiuDietEntity::getUserId,userInfoEntity.getId())));
            return maoqiuDietDto;
        }
        throw new JWTException("jwt有误");
    }
    @Override
    public boolean delDietInfo(Long id){
        return this.removeById(id);
    }
}
