package com.wenyu7980.basic.service.organization.user.handler;

import com.wenyu7980.basic.service.organization.user.domain.User;

/**
 *
 * @author wenyu
 * @date 2020-01-30 
 */
public interface UserHandler {
    /**
     * 创建用户
     * @param user
     * @return
     */
    User addUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void removeUser(String id);
}
