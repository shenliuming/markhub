package com.markhub.system.dao;

import com.markhub.framework.mybatis.dao.BaseDao;
import com.markhub.system.entity.SysMailConfigEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮件配置
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysMailConfigDao extends BaseDao<SysMailConfigEntity> {

}