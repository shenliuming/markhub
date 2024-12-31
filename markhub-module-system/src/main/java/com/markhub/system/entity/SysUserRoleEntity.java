package com.markhub.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.markhub.framework.mybatis.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @Auther: emp
 * @Date: 2024/12/31 21:29
 * @Description: 用户和角色关联表
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("sys_user_role")
public class SysUserRoleEntity extends BaseEntity {

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 用户ID
     */
    private Long userId;

}
