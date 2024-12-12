package com.markhub.framework.mybatis.base.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markhub.framework.mybatis.base.service.BaseService;

/**
 * @param <T> 实体类类型
 * @param <M> Mapper类型
 * @Auther: emp
 * @Date: 2024/12/12 15:48
 * @Description: 规范顶层基础服务实现类。
 * <p>该类提供了基础服务层的通用实现，继承自MyBatis Plus的ServiceImpl类，
 * 并实现了BaseService接口。它封装了对Mapper层的CRUD操作，以及事务管理等基础服务功能。</p>
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements BaseService<T> {

}
