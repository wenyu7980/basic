package com.wenyu7980.basic.service.organization.user.handler;

import com.wenyu7980.basic.common.query.QueryHandler;
import com.wenyu7980.basic.service.organization.user.domain.UserDetail;
import com.wenyu7980.basic.service.organization.user.domain.UserListDetail;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
public abstract class UserQueryHandler
        extends QueryHandler<UserEntity, UserListDetail> {

    /**
     * 用户查询
     * @param userId
     * @param detail
     * @return
     */
    public abstract UserDetail getOne(String userId, boolean detail);
}
