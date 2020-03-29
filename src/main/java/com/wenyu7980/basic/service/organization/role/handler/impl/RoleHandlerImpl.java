package com.wenyu7980.basic.service.organization.role.handler.impl;

import com.wenyu7980.basic.service.organization.menu.entity.MenuEntity;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorEntity;
import com.wenyu7980.basic.service.organization.permission.service.PermissionService;
import com.wenyu7980.basic.service.organization.role.domain.Role;
import com.wenyu7980.basic.service.organization.role.domain.RoleAdd;
import com.wenyu7980.basic.service.organization.role.entity.RoleEntity;
import com.wenyu7980.basic.service.organization.role.handler.RoleHandler;
import com.wenyu7980.basic.service.organization.role.mapper.RoleMapper;
import com.wenyu7980.basic.service.organization.role.service.RoleService;
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
        entity.setMenus(role.getMenuCodes().stream()
                .map(code -> new MenuEntity(entity, code))
                .collect(Collectors.toList()));
        entity.setOperators(role.getOperatorCodes().stream()
                .map(code -> new OperatorEntity(entity, code))
                .collect(Collectors.toList()));
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
        entity.setMenus(role.getMenuCodes().stream()
                .map(code -> new MenuEntity(entity, code))
                .collect(Collectors.toList()));
        entity.setOperators(role.getOperatorCodes().stream()
                .map(code -> new OperatorEntity(entity, code))
                .collect(Collectors.toList()));
        return RoleMapper.map(this.roleService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void removeRole(String id) {
        RoleEntity entity = roleService.findById(id);
        roleService.delete(entity);
    }
}
