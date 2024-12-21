package com.markhub.system.convert;

import com.markhub.system.entity.SysUserEntity;
import com.markhub.system.vo.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Auther: emp
 * @Date: 2024/12/21 14:39
 * @Description:
 */
@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserVO convert(SysUserEntity entity);

    SysUserEntity convert(SysUserVO vo);

    List<SysUserVO> convertList(List<SysUserEntity> list);
}
