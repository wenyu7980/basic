package com.wenyu7980.basic.service.organization.rolepermission.handler.impl;

import com.wenyu7980.basic.service.organization.rolepermission.domain.Role;
import com.wenyu7980.basic.service.organization.rolepermission.domain.RoleAdd;
import com.wenyu7980.basic.service.organization.rolepermission.entity.RoleEntity;
import com.wenyu7980.basic.service.organization.rolepermission.handler.RoleHandler;
import com.wenyu7980.basic.service.organization.rolepermission.mapper.RoleMapper;
import com.wenyu7980.basic.service.organization.rolepermission.service.PermissionService;
import com.wenyu7980.basic.service.organization.rolepermission.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Component
public class RoleHandlerImpl implements RoleHandler {
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Role addRole(RoleAdd role) {
        RoleEntity entity = new RoleEntity();
        entity.setName(role.getName());
        entity.setPermissions(role.getPermissions().stream()
                .map(permission -> this.permissionService
                        .findByMethodAndPath(permission.getMethod(),
                                permission.getPath()))
                .collect(Collectors.toList()));
        entity.setMenus(role.getMenuCodes());
        entity.setOperators(role.getOperatorCodes());
        return RoleMapper.map(this.roleService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Role modifyRole(String id, RoleAdd role) {
        RoleEntity entity = roleService.findById(id);
        entity.setName(role.getName());
        entity.setPermissions(role.getPermissions().stream()
                .map(permission -> this.permissionService
                        .findByMethodAndPath(permission.getMethod(),
                                permission.getPath()))
                .collect(Collectors.toList()));
        entity.setMenus(role.getMenuCodes());
        entity.setOperators(role.getOperatorCodes());
        return RoleMapper.map(this.roleService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void removeRole(String id) {
        RoleEntity entity = roleService.findById(id);
        roleService.delete(entity);
    }
}
