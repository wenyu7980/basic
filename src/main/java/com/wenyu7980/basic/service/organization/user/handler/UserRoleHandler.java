package com.wenyu7980.basic.service.organization.user.handler;

import com.wenyu7980.basic.service.organization.role.domain.Role;
import com.wenyu7980.basic.service.organization.user.domain.User;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-11 
 */
public interface UserRoleHandler {
    /**
     * 用户设置角色
     * @param id
     * @param roleIds
     * @return
     */
    User userSetRoles(String id, Collection<String> roleIds);

    /**
     * 查询用户角色
     * @param id
     * @return
     */
    List<Role> getRoleByUserId(String id);
}
