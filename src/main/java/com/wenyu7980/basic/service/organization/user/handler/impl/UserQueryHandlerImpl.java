package com.wenyu7980.basic.service.organization.user.handler.impl;

import com.wenyu7980.basic.service.organization.user.domain.UserDetail;
import com.wenyu7980.basic.service.organization.user.domain.UserListDetail;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.handler.UserQueryHandler;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Component
public class UserQueryHandlerImpl extends UserQueryHandler {
    @Autowired
    private UserService userService;

    @Override
    public UserDetail getOne(String userId, boolean detailFlag) {
        UserDetail detail = new UserDetail();
        UserMapper.map(userService.findById(userId), detail);
        return detail;
    }

    @Override
    protected UserListDetail mapList(UserEntity entity, boolean detailFlag) {
        UserListDetail detail = new UserListDetail();
        UserMapper.map(entity, detail);
        return detail;
    }

}
