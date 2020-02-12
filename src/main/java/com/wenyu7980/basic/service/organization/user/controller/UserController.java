package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.domain.UserPassword;
import com.wenyu7980.basic.service.organization.user.handler.UserHandler;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ApiResponses({
            @ApiResponse(code = 201, message = "创建成功"),
            @ApiResponse(code = 400, message = "创建失败", response = Error.class)
    })
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public User addUser(@RequestBody @Valid User user) {
        return userHandler.addUser(user);
    }

    @ApiOperation("恢复用户")
    @ApiResponses({
            @ApiResponse(code = 201, message = "成功")
    })
    @PutMapping("{id}/resume")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User resumeUser(@ApiParam("用户id") @PathVariable("id") String id) {
        return userHandler.resumeUser(id);
    }

    @ApiOperation("修改用户密码")
    @ApiResponses({
            @ApiResponse(code = 201, message = "成功")
    })
    @PutMapping("{id}/password")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User passwd(@ApiParam("用户id") @PathVariable("id") String id,
            @RequestBody @Valid UserPassword password) {
        return userHandler.password(id, password);
    }

    @ApiOperation("删除用户")
    @ApiResponses({
            @ApiResponse(code = 204, message = "删除成功"),
            @ApiResponse(code = 404, message = "用户不存在", response = Error.class)
    })
    @DeleteMapping(path = "{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeUser(@PathVariable("id") String id) {
        userHandler.removeUser(id);
    }
}
