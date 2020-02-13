package com.wenyu7980.basic.service.organization.user.handler;

import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.domain.UserAdd;
import com.wenyu7980.basic.service.organization.user.domain.UserPassword;

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
    User addUser(UserAdd user);

    /**
     * 删除用户
     * @param id
     */
    void removeUser(String id);

    /**
     * 恢复已删除的用户
     * @param id
     * @return
     */
    User resumeUser(String id);

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    User password(String id, UserPassword password);
}
