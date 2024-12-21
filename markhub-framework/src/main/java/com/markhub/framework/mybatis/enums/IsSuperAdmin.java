package com.markhub.framework.mybatis.enums;

/**
 * @Auther: emp
 * @Date: 2024/12/21 15:39
 * @Description:
 */
public enum IsSuperAdmin {
    YES(1),
    NO(0);

    private final int code;

    IsSuperAdmin(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
