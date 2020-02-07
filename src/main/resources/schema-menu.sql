DROP TABLE IF EXISTS `sys_menu`;
DROP TABLE IF EXISTS `sys_operator`;

-- 用户菜单表
CREATE TABLE `sys_menu`(
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `code` varchar(64) NOT NULL COMMENT '菜单code',
  primary key(`role_id`,`code`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '用户菜单表';

-- 用户操作权限表
CREATE TABLE `sys_operator`(
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `code` varchar(64) NOT NULL COMMENT '操作code',
  primary key(`role_id`,`code`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '用户操作权限表';
