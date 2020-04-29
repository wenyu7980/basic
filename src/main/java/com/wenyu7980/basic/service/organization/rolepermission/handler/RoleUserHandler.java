package com.wenyu7980.basic.service.organization.rolepermission.handler;

import com.wenyu7980.basic.service.organization.rolepermission.domain.Role;
import com.wenyu7980.basic.service.organization.user.domain.User;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
public interface RoleUserHandler {
    /**
     * 通过角色查询用户
     * @param roleId
     * @return
     */
    List<User> getUsersByRole(String roleId);

    /**
     * 设置角色用户
     * @param roleId
     * @param userIds
     * @return
     */
    Role setUserByRole(String roleId,Collection<String> userIds);
}
