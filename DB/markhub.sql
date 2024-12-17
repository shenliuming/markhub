DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id                      bigint NOT NULL AUTO_INCREMENT COMMENT '用户的唯一标识',
    username                varchar(55) NOT NULL COMMENT '用户登录的用户名',
    password                varchar(125) COMMENT '用户的登录密码',
    real_name               varchar(55) COMMENT '用户的真实姓名',
    avatar                  varchar(200) COMMENT '用户的头像图片链接',
    gender                  tinyint COMMENT '用户性别, 0: 男, 1: 女, 2: 未指定',
    email                   varchar(125) COMMENT '用户的电子邮箱地址',
    mobile                  varchar(25) COMMENT '用户的手机号码',
    org_id                  bigint COMMENT '关联的组织机构ID',
    is_super_admin          tinyint COMMENT '是否为超级管理员, 0: 否, 1: 是',
    status                  tinyint COMMENT '账户状态, 0: 停用, 1: 正常',
    version                 int COMMENT '记录的版本号, 用于控制并发更新',
    deleted                 tinyint COMMENT '删除标识, 0: 未删除, 1: 已删除',
    creator                 bigint COMMENT '创建人',
    create_time             datetime COMMENT '创建时间',
    updater                 bigint COMMENT '更新人',
    update_time             datetime COMMENT '记录的最后更新时间',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='系统用户信息管理表';

