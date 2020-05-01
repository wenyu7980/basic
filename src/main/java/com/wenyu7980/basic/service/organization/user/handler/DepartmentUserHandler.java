package com.wenyu7980.basic.service.organization.user.handler;

import com.wenyu7980.basic.service.organization.user.domain.Department;
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
}
