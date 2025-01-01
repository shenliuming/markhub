package com.markhub.member.service;

import com.markhub.framework.common.utils.PageResult;
import com.markhub.framework.mybatis.service.BaseService;
import com.markhub.member.entity.MemberUserEntity;
import com.markhub.member.query.MemberUserQuery;
import com.markhub.member.vo.MemberUserVO;

import java.util.List;

/**
 * 会员管理
 *
 * @author 阿沐 babamu@126.com
 */
public interface MemberUserService extends BaseService<MemberUserEntity> {

    PageResult<MemberUserVO> page(MemberUserQuery query);

    void save(MemberUserVO vo);

    void update(MemberUserVO vo);

    void delete(List<Long> idList);
}