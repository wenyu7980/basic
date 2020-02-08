package com.wenyu7980.basic.service.organization.user.handler.impl;

import com.wenyu7980.basic.common.query.PageBody;
import com.wenyu7980.basic.common.query.QueryService;
import com.wenyu7980.basic.service.organization.user.domain.UserDetail;
import com.wenyu7980.basic.service.organization.user.domain.UserListDetail;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.handler.UserQueryHandler;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import com.wenyu7980.query.QueryPredicateExpress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Component
public class UserQueryHandlerImpl implements UserQueryHandler {
    @Autowired
    private QueryService<UserEntity> queryService;
    @Autowired
    private UserService userService;

    @Override
    public PageBody<UserListDetail> getUsers(QueryPredicateExpress express,
            Pageable pageable, boolean detail) {
        return PageBody.of(queryService.findAll(express, pageable),
                entity -> new UserListDetail(UserMapper.map(entity)));
    }

    @Override
    public UserDetail getUser(String userId, boolean detail) {
        return new UserDetail(new UserListDetail(
                UserMapper.map(userService.findById(userId))));
    }
}
