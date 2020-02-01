package com.wenyu7980.basic.service.organization.user.handler.impl;

import com.wenyu7980.basic.authorization.util.PasswordUtil;
import com.wenyu7980.basic.exception.code409.ExistedException;
import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.handler.UserHandler;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wenyu
 * @date 2020-01-30 
 */
@Component
public class UserHandlerImpl implements UserHandler {
    @Autowired
    private UserService userService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public User addUser(User user) {
        // 判断用户名是否已使用
        if (userService.existsByUsername(user.getUsername())) {
            throw new ExistedException("用户名{0}已被使用", user.getUsername());

        }
        UserEntity entity = new UserEntity(user.getUsername(),
                PasswordUtil.encode(user.getPassword()));
        return UserMapper.map(userService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void removeUser(String id) {
        UserEntity entity = userService.findById(id);
        entity.setDeletedFlag(true);
        userService.save(entity);
    }
}
