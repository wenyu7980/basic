package com.wenyu7980.basic.service.organization.permission.mapper;

import com.wenyu7980.basic.service.organization.permission.domain.Permission;
import com.wenyu7980.basic.service.organization.permission.entity.PermissionEntity;

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
        permission.setCode(entity.getCode());
        permission.setMethod(entity.getMethod());
        permission.setName(entity.getMethod());
        permission.setPath(entity.getPath());
        return permission;
    }
}
