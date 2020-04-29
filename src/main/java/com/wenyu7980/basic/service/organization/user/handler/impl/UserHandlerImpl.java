package com.wenyu7980.basic.service.organization.user.handler.impl;

import com.wenyu7980.basic.authorization.util.AuthorizationUtil;
import com.wenyu7980.basic.authorization.util.PasswordUtil;
import com.wenyu7980.basic.exception.code403.InsufficientException;
import com.wenyu7980.basic.exception.code409.ExistedException;
import com.wenyu7980.basic.exception.code409.InconsistentException;
import com.wenyu7980.basic.service.organization.user.service.DepartmentService;
import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.domain.UserAdd;
import com.wenyu7980.basic.service.organization.user.domain.UserPassword;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.handler.UserHandler;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 *
 * @author wenyu
 * @date 2020-01-30 
 */
@Component
public class UserHandlerImpl implements UserHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public User addUser(UserAdd user) {
        // 判断用户名是否已使用
        if (userService.existsByUsername(user.getUsername())) {
            throw new ExistedException("用户名{0}已被使用", user.getUsername());

        }
        UserEntity entity = new UserEntity(user.getUsername(), user.getName(),
                PasswordUtil.encode(user.getPassword()));
        return UserMapper.map(userService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void removeUser(String id) {
        UserEntity entity = userService.findById(id);
        if (entity.getDeletedFlag()) {
            throw new InconsistentException("用户:{0}已删除，请勿重复删除",
                    entity.getUsername());
        }
        entity.setDeletedFlag(true);
        userService.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public User resumeUser(String id) {
        UserEntity entity = userService.findById(id);
        if (!entity.getDeletedFlag()) {
            throw new InconsistentException("用户:{0}是正常用户，不需要恢复",
                    entity.getUsername());
        }
        entity.setDeletedFlag(false);
        return UserMapper.map(userService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public User password(String id, UserPassword password) {
        UserEntity entity = userService.findById(id);
        if (!Objects.equals(id, AuthorizationUtil.getUserId())
                && !AuthorizationUtil.get().getSystem()) {
            throw new InsufficientException("非系统管理员，只能修改自己的密码");
        }
        if (!PasswordUtil.encode(password.getOldPassword())
                .equals(entity.getPassword())) {
            throw new InconsistentException("旧密码不正确");
        }
        entity.setPassword(PasswordUtil.encode(password.getNewPassword()));
        return UserMapper.map(userService.save(entity));
    }
}
