INSERT INTO `sys_user`(`id`,`username`,`password`)
VALUES
(replace(uuid(), '-', ''),'admin','5f4dcc3b5aa765d61d8327deb882cf99');
-- 部门配置
INSERT INTO sys_company (id,name)
VALUES
(replace(uuid(), '-', ''),'adminCompany');

INSERT INTO sys_department(id,name,company_id)
SELECT replace(uuid(), '-', ''),'adminDepartment',c.id from sys_company c where c.name='adminCompany';

INSERT INTO sys_department_user(department_id,user_id)
SELECT d.id,u.id from sys_user u,sys_department d where u.username='admin' and d.name='adminDepartment';



-- 权限配置
INSERT INTO `sys_role`(`id`,`name`)
VALUES
(replace(uuid(), '-', ''),'admin');

INSERT INTO `sys_user_role`(`user_id`,`role_id`)
SELECT u.id,r.id FROM sys_user u,sys_role r where r.name = 'admin';

INSERT INTO `sys_role_permission`(`role_id`,`permission_code`)
SELECT r.id,p.code FROM sys_permission p,sys_role r where r.name = 'admin' ;