package com.markhub.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.markhub.framework.mybatis.base.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户实体类。
 *
 * @Auther: emp
 * @Date: 2024/12/21 13:58
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {

    /** 用户ID。 */
    private Long id;

    /** 用户名。 */
    private String username;

    /** 登录密码。 */
    private String password;

    /** 真实姓名。 */
    private String realName;

    /** 头像链接。 */
    private String avatar;

    /** 性别 (0: 男, 1: 女, 2: 未指定)。 */
    private Integer gender;

    /** 邮箱地址。 */
    private String email;

    /** 手机号码。 */
    private String mobile;

    /** 组织机构ID。 */
    private Long orgId;

    /** 是否超级管理员 (0: 否, 1: 是)。 */
    private Integer isSuperAdmin;

    /** 账户状态 (0: 停用, 1: 正常)。 */
    private Integer status;

}
