package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.handler.UserHandler;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * @author wenyu
 * @date 2020-01-28
 */
@Api(description = "用户管理")
@RequestMapping("users")
@RestController
public class UserController {
    @Autowired
    private UserHandler userHandler;

    @PostMapping()
    public User addUser(@RequestBody @Valid User user) {
        return userHandler.addUser(user);
    }
}
