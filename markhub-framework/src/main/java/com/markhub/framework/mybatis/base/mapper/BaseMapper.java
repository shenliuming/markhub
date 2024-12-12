package com.markhub.framework.mybatis.base.mapper;

import com.github.yulichang.base.MPJBaseMapper;

/**
 *
 * @param <T> 实体类类型
 * @author emp
 * @date 2024/12/12 15:35
 * @Description: 规范顶层基础Mapper接口。可以完全抛弃XML
 *  <p>提供基础的数据库操作接口，用于通用的数据访问层逻辑。</p>
 */
public interface BaseMapper<T> extends MPJBaseMapper<T> {

}
