-- password:sysadmin
INSERT INTO `sys_user`(`id`,`username`,`name`,`password`,`system`)
VALUES
(replace(uuid(), '-', ''),'sysadmin','系统管理员','5f4dcc3b5aa765d61d8327deb882cf99','1');

INSERT INTO sys_department_user(department_id,user_id)
SELECT d.id,u.id from sys_user u,sys_department d where u.username='sysadmin' and d.name='adminDepartment';
