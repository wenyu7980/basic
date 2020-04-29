package com.wenyu7980.basic.service.organization.rolepermission.handler.impl;

import com.wenyu7980.basic.service.organization.rolepermission.domain.Role;
import com.wenyu7980.basic.service.organization.rolepermission.entity.RoleEntity;
import com.wenyu7980.basic.service.organization.rolepermission.handler.RoleUserHandler;
import com.wenyu7980.basic.service.organization.rolepermission.mapper.RoleMapper;
import com.wenyu7980.basic.service.organization.rolepermission.service.RoleService;
import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
@Component
public class RoleUserHandlerImpl implements RoleUserHandler {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @Override
    public List<User> getUsersByRole(String roleId) {
        return roleService.findById(roleId).getUsers().stream()
                .map(UserMapper::map).collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Role setUserByRole(String roleId, Collection<String> userIds) {
        RoleEntity entity = roleService.findById(roleId);
        entity.setUsers(
                userIds.stream().map(userId -> userService.findById(userId))
                        .collect(Collectors.toList()));
        return RoleMapper.map(roleService.save(entity));
    }
}
