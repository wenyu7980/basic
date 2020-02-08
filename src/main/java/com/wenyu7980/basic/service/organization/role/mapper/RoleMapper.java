package com.wenyu7980.basic.service.organization.role.mapper;

import com.wenyu7980.basic.common.auditing.mapper.AuditingMapper;
import com.wenyu7980.basic.service.organization.role.domain.Role;
import com.wenyu7980.basic.service.organization.role.entity.RoleEntity;

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
        role.setId(entity.getId());
        role.setName(entity.getName());
        AuditingMapper.mapTo(entity, role);
        return role;
    }
}
