package com.markhub.system.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.markhub.framework.mybatis.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: emp
 * @Date: 2024/12/21 15:45
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_org")
public class SysOrgEntity extends BaseEntity {

    /**
     * 机构ID
     */
    private Long id;

    /**
     * 上级ID
     */
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private Long pid;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 上级名称（非数据库字段）
     */
    @TableField(exist = false)
    private String parentName;

    /**
     * 机构描述
     */
    private String description;

    /**
     * 机构状态（0: 禁用, 1: 启用）
     */
    private Integer status;
}
