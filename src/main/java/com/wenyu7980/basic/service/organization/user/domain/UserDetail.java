package com.wenyu7980.basic.service.organization.user.domain;

import org.springframework.beans.BeanUtils;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
public class UserDetail extends UserListDetail {
    public UserDetail(UserListDetail user) {
        super();
        BeanUtils.copyProperties(user, this);
    }
}
