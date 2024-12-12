package com.markhub.framework.mybatis.base.service;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Auther: emp
 * @Date: 2024/12/12 15:42
 * @Description: 规范顶层基础服务接口。
 * <p>该接口定义了基础服务层的通用操作，为所有业务服务提供基本的CRUD方法和业务逻辑扩展点。</p>
 */
public interface BaseService<T> extends IService<T> {
}
