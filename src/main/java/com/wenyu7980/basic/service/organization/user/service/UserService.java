package com.wenyu7980.basic.service.organization.user.service;

import com.wenyu7980.basic.common.CommonService;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
public interface UserService extends CommonService<UserEntity, String> {
    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    UserEntity findByUsername(String username);
}
