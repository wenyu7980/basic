package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.domain.UserAdd;
import com.wenyu7980.basic.service.organization.user.domain.UserPassword;
import com.wenyu7980.basic.service.organization.user.handler.UserHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户管理
 * @author wenyu
 * @date 2020-01-28
 */
@Api(tags = "用户管理")
@RequestMapping("users")
@RestController
public class UserController {
    @Autowired
    private UserHandler userHandler;

    @ApiOperation("创建用户")
    @PostMapping()
    public User addUser(@RequestBody @Valid UserAdd user) {
        return userHandler.addUser(user);
    }

    @ApiOperation("恢复用户")
    @PutMapping("{id}/resume")
    public User resumeUser(@ApiParam("用户id") @PathVariable("id") String id) {
        return userHandler.resumeUser(id);
    }

    @ApiOperation("修改用户密码")
    @PutMapping("{id}/password")
    public User passwd(@ApiParam("用户id") @PathVariable("id") String id,
            @RequestBody @Valid UserPassword password) {
        return userHandler.password(id, password);
    }

    @ApiOperation("删除用户")
    @DeleteMapping(path = "{id}")
    public void removeUser(@PathVariable("id") String id) {
        userHandler.removeUser(id);
    }
}
