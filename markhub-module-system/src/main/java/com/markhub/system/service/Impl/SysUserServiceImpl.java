package com.markhub.system.service.Impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.markhub.framework.mybatis.base.page.PageResult;
import com.markhub.framework.mybatis.base.service.impl.BaseServiceImpl;
import com.markhub.framework.mybatis.enums.IsSuperAdmin;
import com.markhub.system.convert.SysUserConvert;
import com.markhub.system.entity.SysUserEntity;
import com.markhub.system.mapper.SysUserMapper;
import com.markhub.system.query.SysUserQuery;
import com.markhub.system.service.SysUserService;
import com.markhub.system.vo.SysUserVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: emp
 * @Date: 2024/12/21 15:14
 * @Description:
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {
    @Override
    public PageResult<SysUserVO> page(SysUserQuery query) {
        IPage<SysUserEntity> iPage = queryPage(query,getWrapper(query));

        List<SysUserVO> list = SysUserConvert.INSTANCE.convertList(iPage.getRecords());

        return new PageResult<SysUserVO>(iPage.getCurrent(), iPage.getSize(), iPage.getTotal(),list);
    }

    private LambdaQueryWrapper<SysUserEntity> getWrapper(SysUserQuery query) {

        LambdaQueryWrapper<SysUserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(query.getUsername()), SysUserEntity::getUsername, query.getUsername());
        queryWrapper.eq(StrUtil.isNotBlank(query.getMobile()), SysUserEntity::getMobile, query.getMobile());
        queryWrapper.eq(null != query.getGender(), SysUserEntity::getGender, query.getGender());
        queryWrapper.in(CollectionUtil.isNotEmpty(query.getOrgIds()), SysUserEntity::getEmail, query.getOrgIds());

        return queryWrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long add(SysUserVO userVO) {

        // 唯一性验证
        LambdaQueryWrapper<SysUserEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserEntity::getMobile, userVO.getMobile());
        if (this.count(wrapper) > 0) {
            throw new RuntimeException("手机号已存在");
        }
        SysUserEntity entity = SysUserConvert.INSTANCE.convert(userVO);
        entity.setIsSuperAdmin(IsSuperAdmin.NO.getCode());

        baseMapper.insert(entity);

        return entity.getId();
    }

    @Override
    public void update(SysUserVO userVO) {

    }

    @Override
    public SysUserVO getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
