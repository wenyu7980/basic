package com.wenyu7980.basic.service.organization.user.domain;

import org.springframework.beans.BeanUtils;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
public class UserListDetail extends User {
    protected UserListDetail() {
    }

    public UserListDetail(User user) {
        BeanUtils.copyProperties(user, this);
    }
}
