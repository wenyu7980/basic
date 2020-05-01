-- department
INSERT INTO sys_department(`id`,`name`)
VALUES
(replace(uuid(), '-', ''),'部门1');

-- password:sysadmin
INSERT INTO `sys_user`(`id`,`username`,`name`,`password`,`system`,`department_id`)
VALUES
(replace(uuid(), '-', ''),'sysadmin','系统管理员','5f4dcc3b5aa765d61d8327deb882cf99','1',select max(id) from sys_department);
