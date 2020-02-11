package com.wenyu7980.basic.service.organization.user.mapper;

import com.wenyu7980.basic.common.auditing.mapper.AuditingMapper;
import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.domain.UserSimple;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
public class UserMapper {

    private UserMapper() {
    }

    public static void map(UserEntity entity, User user) {
        user.setId(entity.getId());
        user.setUsername(entity.getUsername());
        user.setSystem(entity.getSystem());
        AuditingMapper.mapTo(entity, user);
    }

    public static User map(UserEntity entity) {
        User user = new User();
        map(entity, user);
        return user;
    }

    public static UserSimple simpleMap(UserEntity entity) {
        UserSimple simple = new UserSimple();
        simple.setId(entity.getId());
        simple.setUsername(entity.getUsername());
        return simple;
    }
}
