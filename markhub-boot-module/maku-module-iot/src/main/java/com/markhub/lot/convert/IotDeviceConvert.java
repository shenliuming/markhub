package com.markhub.lot.convert;

import com.markhub.lot.entity.IotDeviceEntity;
import com.markhub.lot.vo.IotDeviceVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 设备表
 *
 * @author LSF maku_lsf@163.com
 */
@Mapper
public interface IotDeviceConvert {
    IotDeviceConvert INSTANCE = Mappers.getMapper(IotDeviceConvert.class);

    IotDeviceEntity convert(IotDeviceVO vo);

    IotDeviceVO convert(IotDeviceEntity entity);

    List<IotDeviceVO> convertList(List<IotDeviceEntity> list);

}