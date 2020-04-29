package com.wenyu7980.basic.service.organization.rolepermission.controller;

import com.wenyu7980.basic.service.organization.rolepermission.domain.Role;
import com.wenyu7980.basic.service.organization.rolepermission.handler.RoleUserHandler;
import com.wenyu7980.basic.service.organization.user.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
@Api(tags = { "角色管理", "用户角色管理" })
@RestController
@RequestMapping("roles")
public class RoleUserController {
    @Autowired
    private RoleUserHandler roleUserHandler;

    @ApiOperation("查询角色用户")
    @GetMapping("{id}/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUserByRole(
            @ApiParam("角色id") @PathVariable("id") String id) {
        return roleUserHandler.getUsersByRole(id);
    }

    @ApiOperation("修改角色用户")
    @PutMapping("{id}/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Role setUserByRole(@ApiParam("角色id") @PathVariable("id") String id,
            @RequestBody @Valid Set<String> userIds) {
        return roleUserHandler.setUserByRole(id, userIds);
    }
}
