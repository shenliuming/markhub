package com.markhub.framework.security.auth;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: emp
 * @Date: 2024/12/17 21:31
 * @Description: 已经登陆的用户
 */
@Data
public class AuthUser implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户的唯一标识符
     * 唯一标识每个用户，通常与数据库中的主键字段对应
     */
    private Long id;

    /**
     * 用户登录的用户名
     * 用于用户进行身份验证和登录，通常是唯一的
     */
    private String username;

    /**
     * 用户的登录密码
     * 存储用户的密码，通常经过加密处理后存储
     */
    private String password;

    /**
     * 用户的真实姓名
     * 用于记录用户的全名，通常用于展示或个人信息管理
     */
    private String realName;

    /**
     * 用户的头像图片链接
     * 存储用户头像的URL路径，用于显示用户头像
     */
    private String avatar;

    /**
     * 用户性别
     * 0: 男，1: 女，2: 未指定，用于标识用户的性别信息
     */
    private Integer gender;

    /**
     * 用户的电子邮箱地址
     * 用于接收用户的通知、验证码等信息
     */
    private String email;

    /**
     * 用户的手机号码
     * 用于验证用户身份、接收验证码或通知等
     */
    private String mobile;

    /**
     * 用户所属的组织机构ID
     * 用于标识用户所属的组织或部门
     */
    private Long orgId;

    /**
     * 用户账户状态
     * 0: 停用，1: 正常，表示账户的当前状态
     */
    private Integer status;

    /**
     * 是否为超级管理员
     * 0: 否，1: 是，表示用户是否具有超级管理员权限
     */
    private Integer isSuperAdmin = 0;

    /**
     * 用户账户的创建时间
     * 记录用户账户的创建日期和时间，通常用于账户管理和审计
     */
    private LocalDateTime createTime;

    /**
     * 用户的数据访问范围
     */
    private List<Long> userDataAccessScope;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }
}
