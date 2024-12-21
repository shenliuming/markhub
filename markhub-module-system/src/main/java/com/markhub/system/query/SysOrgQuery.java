package com.markhub.system.query;

import lombok.Data;

/**
 * @Auther: emp
 * @Date: 2024/12/21 16:00
 * @Description: 机构查询条件
 */
@Data
public class SysOrgQuery {
    /**
     * ID
     */
    private Long id;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 上级ID
     */
    private Long pid;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 机构状态（0: 禁用, 1: 启用）
     */
    private Integer status;
}