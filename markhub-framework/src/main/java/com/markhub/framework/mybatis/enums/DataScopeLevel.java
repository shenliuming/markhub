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
public enum DataScopeLevel {

    SELF(0), // 仅本人数据权限
    ALL(1), // 全部数据权限

    ORG_AND_CHILD(2), // 本机构及子机构数据权限
    ORG_ONLY(3)  // 本机构数据权限
    ;

    /**
     * 范围
     */
    private final Integer scope;

}
