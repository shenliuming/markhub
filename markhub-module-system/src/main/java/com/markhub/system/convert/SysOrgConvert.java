package com.markhub.system.convert;

import com.markhub.system.entity.SysOrgEntity;
import com.markhub.system.vo.SysOrgVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Auther: emp
 * @Date: 2024/12/21 17:12
 * @Description:
 */
@Mapper
public interface SysOrgConvert {
    SysOrgConvert INSTANCE = Mappers.getMapper(SysOrgConvert.class);

    SysOrgVO convert(SysOrgEntity entity);

    SysOrgEntity convert(SysOrgVO vo);

    List<SysOrgVO> convertList(List<SysOrgEntity> list);
}
