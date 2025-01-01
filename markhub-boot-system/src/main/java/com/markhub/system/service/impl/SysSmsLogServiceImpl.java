package com.markhub.system.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import com.markhub.framework.common.utils.PageResult;
import com.markhub.framework.mybatis.service.impl.BaseServiceImpl;
import com.markhub.system.convert.SysSmsLogConvert;
import com.markhub.system.dao.SysSmsLogDao;
import com.markhub.system.entity.SysSmsLogEntity;
import com.markhub.system.query.SysSmsLogQuery;
import com.markhub.system.service.SysSmsLogService;
import com.markhub.system.vo.SysSmsLogVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 短信日志
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@Service
@AllArgsConstructor
public class SysSmsLogServiceImpl extends BaseServiceImpl<SysSmsLogDao, SysSmsLogEntity> implements SysSmsLogService {

    @Override
    public PageResult<SysSmsLogVO> page(SysSmsLogQuery query) {
        IPage<SysSmsLogEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(SysSmsLogConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }


    private LambdaQueryWrapper<SysSmsLogEntity> getWrapper(SysSmsLogQuery query) {
        LambdaQueryWrapper<SysSmsLogEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(query.getPlatform() != null, SysSmsLogEntity::getPlatform, query.getPlatform());
        wrapper.like(StrUtil.isNotBlank(query.getMobile()), SysSmsLogEntity::getMobile, query.getMobile());
        wrapper.orderByDesc(SysSmsLogEntity::getId);
        return wrapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}