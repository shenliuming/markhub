package com.markhub.system.service;

import com.markhub.framework.mybatis.base.page.PageResult;
import com.markhub.framework.mybatis.base.service.BaseService;
import com.markhub.system.entity.SysUserEntity;
import com.markhub.system.query.SysUserQuery;
import com.markhub.system.vo.SysUserVO;

/**
 * @Auther: emp
 * @Date: 2024/12/21 14:42
 * @Description:
 */
public interface SysUserService extends BaseService<SysUserEntity> {

    /**
     * 分页查询用户。
     *
     * @param query 查询条件
     * @return 用户列表
     */
    PageResult<SysUserVO> page(SysUserQuery query);

    /**
     * 新增用户。
     *
     * @param userVO 用户视图对象
     * @return 新增用户的ID
     */
    Long add(SysUserVO userVO);

    /**
     * 更新用户。
     *
     * @param userVO 用户视图对象
     */
    void update(SysUserVO userVO);

    /**
     * 根据ID查询用户。
     *
     * @param id 用户ID
     * @return 用户视图对象
     */
    SysUserVO getById(Long id);

    /**
     * 根据ID删除用户。
     *
     * @param id 用户ID
     */
    void deleteById(Long id);
}
