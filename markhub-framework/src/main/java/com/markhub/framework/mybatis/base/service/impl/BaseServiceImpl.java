package com.markhub.framework.mybatis.base.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.markhub.framework.mybatis.annotation.DataScope;
import com.markhub.framework.mybatis.base.query.BaseQuery;
import com.markhub.framework.mybatis.base.service.BaseService;

/**
 * @param <T> 实体类类型
 * @param <M> mapper类
 * @Auther: emp
 * @Date: 2024/12/12 15:48
 * @Description: 规范顶层基础服务实现类。
 * <p>该类提供了基础服务层的通用实现，继承自MyBatis Plus的ServiceImpl类，
 * 并实现了BaseService接口。它封装了对Mapper层的CRUD操作，以及事务管理等基础服务功能。</p>
 */
public class BaseServiceImpl<M extends BaseMapper<T>,T> extends ServiceImpl<M,T> implements BaseService<T> {

    /**
     * 分页查询（带数据权限控制）
     *
     * @param query 分页参数
     * @param queryWrapper 查询条件
     * @return 分页结果
     */
    @DataScope(orgIdAlias = "org_id")
    public IPage<T> queryPage(BaseQuery query, LambdaQueryWrapper<T> queryWrapper) {
        IPage<T> page = getPage(query);
        return this.page(page, queryWrapper); // 数据权限逻辑通过注解自动处理
    }

    /**
     * 获取分页对象
     *
     * @param query 分页参数
     */
    protected IPage<T> getPage(BaseQuery query) {
        Page<T> page = new Page<>(query.getPageNo(), query.getPageSize());

        if (StrUtil.isNotBlank(query.getSortBy())) {
            if (query.isAsc()) {
                return page.addOrder(OrderItem.asc(query.getSortBy()));
            } else {
                return page.addOrder(OrderItem.desc(query.getSortBy()));
            }
        }

        return page;
    }
}
