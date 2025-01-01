package com.markhub.system.dao;

import com.markhub.framework.mybatis.dao.BaseDao;
import com.markhub.system.entity.SysPostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 岗位管理
*
* @author 阿沐 babamu@126.com
*/
@Mapper
public interface SysPostDao extends BaseDao<SysPostEntity> {
	
}