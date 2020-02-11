package com.wenyu7980.basic.service.organization.user.handler;

import com.wenyu7980.basic.service.organization.user.domain.User;

import java.util.Collection;

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
}
