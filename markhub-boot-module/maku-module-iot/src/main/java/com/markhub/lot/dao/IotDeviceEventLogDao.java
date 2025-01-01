package com.markhub.lot.dao;

import com.markhub.framework.mybatis.dao.BaseDao;
import com.markhub.lot.entity.IotDeviceEventLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备事件日志
 *
 * @author LSF maku_lsf@163.com
 */
@Mapper
public interface IotDeviceEventLogDao extends BaseDao<IotDeviceEventLogEntity> {

}