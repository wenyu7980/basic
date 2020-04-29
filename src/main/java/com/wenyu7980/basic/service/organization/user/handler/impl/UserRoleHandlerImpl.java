package com.wenyu7980.basic.service.organization.user.handler.impl;

import com.wenyu7980.basic.service.organization.rolepermission.domain.Role;
import com.wenyu7980.basic.service.organization.rolepermission.mapper.RoleMapper;
import com.wenyu7980.basic.service.organization.rolepermission.service.RoleService;
import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.handler.UserRoleHandler;
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
 * @date 2020-02-11 
 */
@Component
public class UserRoleHandlerImpl implements UserRoleHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public User userSetRoles(String id, Collection<String> roleIds) {
        UserEntity entity = userService.findById(id);
        entity.setRoles(roleIds.stream().map(role -> roleService.findById(role))
                .collect(Collectors.toList()));
        return UserMapper.map(entity);
    }

    @Override
    public List<Role> getRoleByUserId(String id) {
        UserEntity entity = userService.findById(id);
        return entity.getRoles().stream().map(RoleMapper::map)
                .collect(Collectors.toList());
    }
}
