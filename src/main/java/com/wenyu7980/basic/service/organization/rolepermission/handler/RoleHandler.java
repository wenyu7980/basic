package com.wenyu7980.basic.service.organization.rolepermission.handler;

import com.wenyu7980.basic.service.organization.rolepermission.domain.Role;
import com.wenyu7980.basic.service.organization.rolepermission.domain.RoleAdd;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
public interface RoleHandler {
    /**
     * 创建角色
     * @param role
     * @return
     */
    Role addRole(RoleAdd role);

    /**
     * 修改角色
     * @param id
     * @param role
     * @return
     */
    Role modifyRole(String id, RoleAdd role);

    /**
     * 移除角色
     * @param id
     */
    void removeRole(String id);
}
