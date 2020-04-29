package com.wenyu7980.basic.service.organization.rolepermission.mapper;

import com.wenyu7980.basic.common.auditing.mapper.AuditingMapper;
import com.wenyu7980.basic.service.organization.rolepermission.entity.RoleEntity;
import com.wenyu7980.basic.service.organization.rolepermission.domain.Role;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
public class RoleMapper {
    private RoleMapper() {
    }

    public static Role map(RoleEntity entity) {
        Role role = new Role();
        map(entity, role);
        return role;
    }

    public static void map(RoleEntity entity, Role role) {
        role.setId(entity.getId());
        role.setName(entity.getName());
        AuditingMapper.mapTo(entity, role);
    }
}
