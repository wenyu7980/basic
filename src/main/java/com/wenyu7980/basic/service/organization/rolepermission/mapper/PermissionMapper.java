package com.wenyu7980.basic.service.organization.rolepermission.mapper;

import com.wenyu7980.basic.service.organization.rolepermission.domain.Permission;
import com.wenyu7980.basic.service.organization.rolepermission.entity.PermissionEntity;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
public class PermissionMapper {
    private PermissionMapper() {
    }

    public static Permission map(PermissionEntity entity) {
        Permission permission = new Permission();
        permission.setMethod(entity.getMethod());
        permission.setName(entity.getName());
        permission.setPath(entity.getPath());
        return permission;
    }
}
