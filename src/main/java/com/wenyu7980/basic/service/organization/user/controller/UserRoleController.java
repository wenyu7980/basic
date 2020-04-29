package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.authorization.annotation.AuthRequest;
import com.wenyu7980.basic.authorization.util.AuthorizationUtil;
import com.wenyu7980.basic.service.organization.rolepermission.domain.Role;
import com.wenyu7980.basic.service.organization.rolepermission.domain.RoleMenuOperator;
import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.handler.UserRoleHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = { "用户管理" })
@RequestMapping("users")
@RestController
public class UserRoleController {
    @Autowired
    private UserRoleHandler userRoleHandler;

    @ApiOperation("用户角色设置")
    @PutMapping("{id}/roles")
    public User userRoles(@ApiParam("用户id") @PathVariable("id") String id,
            @RequestBody @Valid @NotNull Set<String> roleIds) {
        return userRoleHandler.userSetRoles(id, roleIds);
    }

    @ApiOperation("用户角色查询")
    @GetMapping("{id}/roles")
    public List<Role> getUserRoles(
            @ApiParam("用户id") @PathVariable("id") String id) {
        return userRoleHandler.getRoleByUserId(id);
    }

    @ApiOperation("用户菜单操作查询")
    @GetMapping("menuoperators")
    @AuthRequest(check = false)
    public RoleMenuOperator getMenuOperators() {
        return userRoleHandler.getMenuOperators(AuthorizationUtil.getUserId());
    }

}
