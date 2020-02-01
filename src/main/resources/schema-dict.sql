DROP TABLE IF EXISTS `sys_dict`;
DROP TABLE IF EXISTS `sys_dict_item`;

-- 字典表
CREATE TABLE `sys_dict`(
  `code` varchar(45) NOT NULL COMMENT '字典code',
  `name` varchar(128) NOT NULL COMMENT '字典名',
  `system_flag` int(1) NOT NULL DEFAULT 0 COMMENT '是否是系统字典',
  `remark` varchar(255) COMMENT '备注',
  primary key(`code`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '字典表';

-- 字典项表
CREATE TABLE `sys_dict_item`(
  `dict_code` varchar(45) NOT NULL COMMENT '字典code',
  `code` varchar(45) NOT NULL COMMENT '字典项code',
  `name` varchar(128) NOT NULL COMMENT '字典项名',
  primary key(`dict_code`,`code`)
)
ENGINE=innodb DEFAULT CHARACTER SET utf8mb4
COMMENT '字典项表';