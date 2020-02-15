package com.wenyu7980.basic.service.organization.department.handler;

import com.wenyu7980.basic.service.organization.department.domain.Department;
import com.wenyu7980.basic.service.organization.user.domain.User;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-02-14 
 */
public interface DepartmentUserHandler {
    /**
     * 查询部门员工
     * @param id
     * @return
     */
    List<User> getUserByDepartment(String id);

    /**
     * 修改部门员工
     * @param id
     * @param userIds
     * @return
     */
    Department modifyUser(String id, Set<String> userIds);

    /**
     * 查询部门管理员
     * @param id
     * @return
     */
    List<User> getAdminByDepartment(String id);

    /**
     * 修改部门管理员
     * @param id
     * @param userIds
     * @return
     */
    Department modifyAdmin(String id, Set<String> userIds);
}
