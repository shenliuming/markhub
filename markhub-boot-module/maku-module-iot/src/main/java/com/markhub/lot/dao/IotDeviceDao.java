package com.markhub.lot.dao;

import com.markhub.framework.mybatis.dao.BaseDao;
import com.markhub.lot.entity.IotDeviceEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备表
 *
 * @author LSF maku_lsf@163.com
 */
@Mapper
public interface IotDeviceDao extends BaseDao<IotDeviceEntity> {

}