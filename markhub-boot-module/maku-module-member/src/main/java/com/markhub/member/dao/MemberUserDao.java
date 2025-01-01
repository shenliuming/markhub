package com.markhub.member.dao;

import com.markhub.framework.mybatis.dao.BaseDao;
import com.markhub.member.entity.MemberUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员管理
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface MemberUserDao extends BaseDao<MemberUserEntity> {

}