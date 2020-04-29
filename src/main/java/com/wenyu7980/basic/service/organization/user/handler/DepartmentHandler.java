package com.wenyu7980.basic.service.organization.user.handler;

import com.wenyu7980.basic.service.organization.user.domain.Department;
import com.wenyu7980.basic.service.organization.user.domain.DepartmentAdd;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
public interface DepartmentHandler {
    /**
     * 创建部门
     * @param department
     * @return
     */
    Department addDepartment(DepartmentAdd department);

    /***
     * 删除部门
     * @param id
     */
    void remove(String id);

    /**
     * 修改
     * @param id
     * @param department
     * @return
     */
    Department modify(String id, DepartmentAdd department);
}
