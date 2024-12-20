DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id                      bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
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

DROP TABLE IF EXISTS sys_org;
CREATE TABLE sys_org
(
    id                      bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    pid                     bigint COMMENT '上级组织机构ID',
    name                    varchar(55) COMMENT '组织机构名称',
    sort                    int COMMENT '排序',
    version                 int COMMENT '记录的版本号, 用于控制并发更新',
    deleted                 tinyint COMMENT '删除标识, 0: 未删除, 1: 已删除',
    creator                 bigint COMMENT '创建人',
    create_time             datetime COMMENT '创建时间',
    updater                 bigint COMMENT '更新人',
    update_time             datetime COMMENT '记录的最后更新时间',
    primary key (id),
    key idx_pid (pid)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='organization组织机构信息管理表';

DROP TABLE IF EXISTS sys_role;
create table sys_role
(
    id                      bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    name                    varchar(55) COMMENT '角色名称',
    remark                  varchar(100) COMMENT '备注',
    data_scope              tinyint COMMENT '数据范围  0：本人数据  1：全部数据  2：本组织机构及子机构  3：本组织机构  ',
    org_id                  bigint COMMENT '关联的组织机构ID',
    version                 int COMMENT '记录的版本号, 用于控制并发更新',
    deleted                 tinyint COMMENT '删除标识, 0: 未删除, 1: 已删除',
    creator                 bigint COMMENT '创建人',
    create_time             datetime COMMENT '创建时间',
    updater                 bigint COMMENT '更新人',
    update_time             datetime COMMENT '记录的最后更新时间',
    primary key (id),
    key idx_org_id (org_id)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT ='角色管理表';

DROP TABLE IF EXISTS sys_user_role;
create table sys_user_role
(
    id                      bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
    role_id                 bigint COMMENT '角色ID',
    user_id                 bigint COMMENT '用户ID',
    version                 int COMMENT '记录的版本号, 用于控制并发更新',
    deleted                 tinyint COMMENT '删除标识, 0: 未删除, 1: 已删除',
    creator                 bigint COMMENT '创建人',
    create_time             datetime COMMENT '创建时间',
    updater                 bigint COMMENT '更新人',
    update_time             datetime COMMENT '记录的最后更新时间',
    primary key (id),
    key idx_role_id (role_id),
    key idx_user_id (user_id)
) ENGINE = InnoDB DEFAULT CHARACTER SET utf8mb4 COMMENT ='用户角色关系表';

DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu
(
    id                      BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    pid                     BIGINT COMMENT '上级菜单ID',
    name                    VARCHAR(255) COMMENT '菜单名称',
    url                     VARCHAR(255) COMMENT '菜单路径URL',
    authority               VARCHAR(500) COMMENT '授权标识(多个用逗号分隔，例如：sys:menu:list,sys:menu:save)',
    type                    TINYINT COMMENT '菜单类型  0：菜单   1：按钮   2：接口',
    open_style              TINYINT COMMENT '打开方式  0：内部   1：外部',
    icon                    VARCHAR(50) COMMENT '菜单图标样式',
    sort                    INT COMMENT '菜单排序',
    version                 int COMMENT '记录的版本号, 用于控制并发更新',
    deleted                 tinyint COMMENT '删除标识, 0: 未删除, 1: 已删除',
    creator                 bigint COMMENT '创建人',
    create_time             datetime COMMENT '创建时间',
    updater                 bigint COMMENT '更新人',
    update_time             datetime COMMENT '记录的最后更新时间',
    PRIMARY KEY (id),
    KEY idx_pid (pid)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='菜单信息管理表';

DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu
(
    id                      BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    role_id                 BIGINT COMMENT '角色ID',
    menu_id                 BIGINT COMMENT '菜单ID',
    version                 int COMMENT '记录的版本号, 用于控制并发更新',
    deleted                 tinyint COMMENT '删除标识, 0: 未删除, 1: 已删除',
    creator                 bigint COMMENT '创建人',
    create_time             datetime COMMENT '创建时间',
    updater                 bigint COMMENT '更新人',
    update_time             datetime COMMENT '记录的最后更新时间',
    PRIMARY KEY (id),
    KEY idx_role_id (role_id),
    KEY idx_menu_id (menu_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='角色与菜单关联关系表';

DROP TABLE IF EXISTS sys_role_data_scope;
CREATE TABLE sys_role_data_scope
(
    id                      BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    role_id                 BIGINT COMMENT '角色ID',
    org_id                  BIGINT COMMENT '机构ID',
    version                 int COMMENT '记录的版本号, 用于控制并发更新',
    deleted                 tinyint COMMENT '删除标识, 0: 未删除, 1: 已删除',
    creator                 bigint COMMENT '创建人',
    create_time             datetime COMMENT '创建时间',
    updater                 bigint COMMENT '更新人',
    update_time             datetime COMMENT '记录的最后更新时间',
    PRIMARY KEY (id),
    KEY idx_role_id (role_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='角色数据权限关系表';

DROP TABLE IF EXISTS sys_dict_type;
CREATE TABLE sys_dict_type
(
    id                      BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    dict_type               VARCHAR(100) NOT NULL COMMENT '字典类型编码',
    dict_name               VARCHAR(255) NOT NULL COMMENT '字典类型名称',
    remark                  VARCHAR(255) COMMENT '备注信息',
    sort                    INT COMMENT '排序',
    pid                     BIGINT COMMENT '上级字典节点ID',
    has_child               TINYINT DEFAULT 0 COMMENT '是否有子节点  0：否  1：是',
    version                 int COMMENT '记录的版本号, 用于控制并发更新',
    deleted                 tinyint COMMENT '删除标识, 0: 未删除, 1: 已删除',
    creator                 bigint COMMENT '创建人',
    create_time             datetime COMMENT '创建时间',
    updater                 bigint COMMENT '更新人',
    update_time             datetime COMMENT '记录的最后更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='字典类型信息管理表';

DROP TABLE IF EXISTS sys_dict_data;
CREATE TABLE sys_dict_data
(
    id                      BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    dict_type_id            BIGINT NOT NULL COMMENT '所属字典类型ID',
    dict_label              VARCHAR(255) NOT NULL COMMENT '字典显示标签',
    dict_value              VARCHAR(255) COMMENT '字典实际值',
    remark                  VARCHAR(255) COMMENT '备注信息',
    sort                    INT COMMENT '排序',
    version                 int COMMENT '记录的版本号, 用于控制并发更新',
    deleted                 tinyint COMMENT '删除标识, 0: 未删除, 1: 已删除',
    creator                 bigint COMMENT '创建人',
    create_time             datetime COMMENT '创建时间',
    updater                 bigint COMMENT '更新人',
    update_time             datetime COMMENT '记录的最后更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='字典数据信息管理表';

