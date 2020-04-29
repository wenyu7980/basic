package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.service.organization.rolepermission.domain.Role;
import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.handler.UserRoleHandler;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-02-11 
 */
@Api(tags = { "用户管理", "用户角色管理" })
@RequestMapping("users")
@RestController
public class UserRoleController {
    @Autowired
    private UserRoleHandler userRoleHandler;

    @ApiOperation("用户角色设置")
    @ApiResponses({
            @ApiResponse(code = 201, message = "创建成功"),
            @ApiResponse(code = 400, message = "创建失败", response = Error.class)
    })
    @PutMapping("{id}/roles")
    @ResponseStatus(code = HttpStatus.CREATED)
    public User userRoles(@ApiParam("用户id") @PathVariable("id") String id,
            @RequestBody @Valid @NotNull Set<String> roleIds) {
        return userRoleHandler.userSetRoles(id, roleIds);
    }

    @ApiOperation("用户角色查询")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 404, message = "用户不存在", response = Error.class)
    })
    @GetMapping("{id}/roles")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Role> getUserRoles(
            @ApiParam("用户id") @PathVariable("id") String id) {
        return userRoleHandler.getRoleByUserId(id);
    }
}
