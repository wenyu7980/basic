package com.wenyu7980.basic.service.organization.user.component;

import com.wenyu7980.basic.service.organization.user.domain.UserSimple;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
@Component
public class UserComponent {
    @Autowired
    private UserService userService;

    /**
     * 通用用户id获取user
     * @param id
     * @return
     */
    public UserSimple getUserById(String id) {
        return UserMapper.simpleMap(userService.findById(id));
    }
}
