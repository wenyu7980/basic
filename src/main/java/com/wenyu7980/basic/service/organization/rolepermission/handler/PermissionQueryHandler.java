package com.wenyu7980.basic.service.organization.rolepermission.handler;

import com.wenyu7980.basic.service.organization.rolepermission.domain.Permission;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
public interface PermissionQueryHandler {
    /**
     * 查询权限
     * @return
     */
    List<Permission> getPermissions();
}
