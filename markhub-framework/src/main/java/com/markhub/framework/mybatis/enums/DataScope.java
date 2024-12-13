package com.markhub.framework.mybatis.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: emp
 * @Date: 2024/12/13 20:33
 * @Description: 数据权限范围
 */
@Getter
@AllArgsConstructor
public enum DataScope {

    ALL(1), // 全部数据权限

    DEPT_CUSTOM(2), // 指定部门数据权限
    DEPT_ONLY(3), // 部门数据权限
    DEPT_AND_CHILD(4), // 部门及以下数据权限

    SELF(5); // 仅本人数据权限

    /**
     * 范围
     */
    private final Integer scope;

}
