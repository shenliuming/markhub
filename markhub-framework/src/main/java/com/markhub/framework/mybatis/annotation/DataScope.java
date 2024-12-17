package com.markhub.framework.mybatis.annotation;

import java.lang.annotation.*;

/**
 * @Auther: emp
 * @Date: 2024/12/17 21:21
 * @Description:
 */
@Target(ElementType.METHOD) // 仅作用于方法
@Retention(RetentionPolicy.RUNTIME) // 运行时生效
@Documented
public @interface DataScope {
    /**
     * 表别名，用于多表关联时指定表别名
     */
    String tableAlias() default "";

    /**
     * 机构ID别名，默认是 "org_id" 暂时使用机构，后续改造
     */
    String orgIdAlias() default "org_id";
}
