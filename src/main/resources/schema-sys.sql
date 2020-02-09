DROP TABLE IF EXISTS `sys_token`;
DROP TABLE IF EXISTS `sys_user`;
DROP TABLE IF EXISTS `sys_company`;
DROP TABLE IF EXISTS `sys_department`;
DROP TABLE IF EXISTS `sys_department_user`;
DROP TABLE IF EXISTS `sys_department_admin`;
DROP TABLE IF EXISTS `sys_permission`;
DROP TABLE IF EXISTS `sys_role`;
DROP TABLE IF EXISTS `sys_user_role`;
DROP TABLE IF EXISTS `sys_role_permission`;

-- TOKEN表
CREATE TABLE `sys_token`(
  `token` varchar(32) NOT NULL COMMENT 'token',
  `type` varchar(45) NOT NULL COMMENT '类型',
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `department_id` varchar(32) COMMENT '部门id',
  `company_id` varchar(32) COMMENT '公司id',
  `system` int(1) COMMENT '系统管理员',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `expire` bigint(20) NOT NULL COMMENT '过期时间',
  `valid` int(1) NOT NULL DEFAULT 1 COMMENT '是否有效',
  `invalid_date_time` datetime COMMENT '过期时间',
  `login_date_time` datetime NOT NULL COMMENT '登录时间',
  primary key(`token`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT 'TOKEN表';

-- 用户表
CREATE TABLE `sys_user`(
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `system` int(1) NOT NULL DEFAULT 0 COMMENT '系统管理员',
  `created_user_id` varchar(32) COMMENT '创建者',
  `created_date_time` datetime COMMENT '创建时间',
  `updated_user_id` varchar(32) COMMENT '更新者',
  `updated_date_time` datetime COMMENT '更新时间时间',
  `deleted_flag` int(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `deleted_user_id` varchar(32) COMMENT '删除者',
  `deleted_date_time` datetime COMMENT '删除时间',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '用户表';

-- 公司表
CREATE TABLE `sys_company`(
  `id` varchar(32) NOT NULL COMMENT '公司id',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `admin_id` varchar(32) COMMENT '公司管理员id',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '公司表';

-- 部门表
CREATE TABLE `sys_department`(
  `id` varchar(32) NOT NULL COMMENT '部门id',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `parent_id` varchar(32) COMMENT '上级部门id',
  `company_id` varchar(32) NOT NULL COMMENT '所属公司id',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '部门表';

-- 部门用户表
CREATE TABLE `sys_department_user`(
  `department_id` varchar(32) NOT NULL COMMENT '部门id',
  `user_id` varchar(255) NOT NULL COMMENT '用户id',
  primary key(`department_id`,`user_id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '部门用户表';

-- 部门管理员表
CREATE TABLE `sys_department_admin`(
  `department_id` varchar(32) NOT NULL COMMENT '部门id',
  `user_id` varchar(255) NOT NULL COMMENT '用户id',
  primary key(`department_id`,`user_id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '部门管理员表';

-- 权限表
CREATE TABLE `sys_permission`(
  `method` varchar(45) NOT NULL COMMENT '请求方法',
  `path` varchar(255) NOT NULL COMMENT '路径',
  `name` varchar(255) NOT NULL COMMENT '名称',
  primary key(`method`,`path`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '权限表';

-- 角色表
CREATE TABLE `sys_role`(
  `id` varchar(32) NOT NULL COMMENT '角色id',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `created_user_id` varchar(32) COMMENT '创建者',
  `created_date_time` datetime COMMENT '创建时间',
  `updated_user_id` varchar(32) COMMENT '更新者',
  `updated_date_time` datetime COMMENT '更新时间时间',
  `deleted_flag` int(1) NOT NULL DEFAULT 0 COMMENT '删除标志',
  `deleted_user_id` varchar(32) COMMENT '删除者',
  `deleted_date_time` datetime COMMENT '删除时间',
  primary key(`id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '角色表';

-- 角色权限表
CREATE TABLE `sys_role_permission`(
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `method` varchar(45) NOT NULL COMMENT '请求方法',
  `path` varchar(255) NOT NULL COMMENT '路径',
  primary key(`role_id`,`method`,`path`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '角色权限表';

-- 用户角色表
CREATE TABLE `sys_user_role`(
  `user_id` varchar(32) NOT NULL COMMENT '用户id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  primary key(`user_id`,`role_id`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '用户角色表';