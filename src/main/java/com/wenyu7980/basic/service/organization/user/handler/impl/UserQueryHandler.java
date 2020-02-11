package com.wenyu7980.basic.service.organization.user.handler.impl;

import com.wenyu7980.basic.common.query.QueryHandler;
import com.wenyu7980.basic.service.organization.user.domain.UserDetail;
import com.wenyu7980.basic.service.organization.user.domain.UserListDetail;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Component
public class UserQueryHandler
        extends QueryHandler<UserEntity, UserListDetail, UserDetail> {

    @Override
    protected UserListDetail mapListDetail(UserEntity entity, boolean detailFlag) {
        UserListDetail detail1 = new UserListDetail();
        UserMapper.map(entity, detail1);
        if (detailFlag) {
            mapListDetail(entity, detail1);
        }
        return detail1;
    }

    private void mapListDetail(UserEntity entity, UserListDetail detail1) {
    }

    @Override
    protected UserDetail mapDetail(UserEntity entity, boolean detailFlag) {
        UserDetail detail1 = new UserDetail();
        UserMapper.map(entity, detail1);
        if (detailFlag) {
            mapListDetail(entity, detailFlag);
        }
        return detail1;
    }
}
