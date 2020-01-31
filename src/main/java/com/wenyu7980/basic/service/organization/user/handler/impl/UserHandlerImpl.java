package com.wenyu7980.basic.service.organization.user.handler.impl;

import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.handler.UserHandler;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public User addUser(User user) {
        UserEntity entity = new UserEntity(user.getUsername(),
                user.getPassword());
        return UserMapper.map(userService.save(entity));
    }
}
