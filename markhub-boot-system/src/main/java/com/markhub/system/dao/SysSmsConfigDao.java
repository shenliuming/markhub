package com.markhub.system.dao;

import com.markhub.framework.mybatis.dao.BaseDao;
import com.markhub.system.entity.SysSmsConfigEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信配置
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysSmsConfigDao extends BaseDao<SysSmsConfigEntity> {

}