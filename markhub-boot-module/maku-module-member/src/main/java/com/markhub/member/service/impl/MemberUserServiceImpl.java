package com.markhub.member.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import com.markhub.framework.common.utils.PageResult;
import com.markhub.framework.mybatis.service.impl.BaseServiceImpl;
import com.markhub.member.convert.MemberUserConvert;
import com.markhub.member.entity.MemberUserEntity;
import com.markhub.member.query.MemberUserQuery;
import com.markhub.member.vo.MemberUserVO;
import com.markhub.member.dao.MemberUserDao;
import com.markhub.member.service.MemberUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 会员管理
 *
 * @author 阿沐 babamu@126.com
 * @since 1.0.0 2024-03-11
 */
@Service
@AllArgsConstructor
public class MemberUserServiceImpl extends BaseServiceImpl<MemberUserDao, MemberUserEntity> implements MemberUserService {

    @Override
    public PageResult<MemberUserVO> page(MemberUserQuery query) {
        IPage<MemberUserEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));

        return new PageResult<>(MemberUserConvert.INSTANCE.convertList(page.getRecords()), page.getTotal());
    }

    private LambdaQueryWrapper<MemberUserEntity> getWrapper(MemberUserQuery query){
        LambdaQueryWrapper<MemberUserEntity> wrapper = Wrappers.lambdaQuery();

        return wrapper;
    }

    @Override
    public void save(MemberUserVO vo) {
        MemberUserEntity entity = MemberUserConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(MemberUserVO vo) {
        MemberUserEntity entity = MemberUserConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

}