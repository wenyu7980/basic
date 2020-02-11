package com.wenyu7980.basic.service.organization.role.controller;

import com.wenyu7980.basic.authorization.util.AuthorizationUtil;
import com.wenyu7980.basic.exception.code403.InsufficientException;
import com.wenyu7980.basic.service.organization.role.domain.Role;
import com.wenyu7980.basic.service.organization.role.domain.RoleAdd;
import com.wenyu7980.basic.service.organization.role.handler.RoleHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Api(tags = "角色权限管理")
@RestController
@RequestMapping("roles")
public class RoleController {
    @Autowired
    private RoleHandler roleHandler;

    @ApiOperation("创建角色")
    @ApiResponses({
            @ApiResponse(code = 201, message = "创建成功")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role addRole(@RequestBody @Valid RoleAdd role) {
        if (!AuthorizationUtil.get().getSystem()) {
            throw new InsufficientException("只有系统管理员才可以创建角色");
        }
        return roleHandler.addRole(role);
    }

    @ApiOperation("修改角色")
    @ApiResponses({
            @ApiResponse(code = 201, message = "修改成功")
    })
    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Role modifyRole(@PathVariable(name = "id") String id,
            @RequestBody @Valid RoleAdd role) {
        if (!AuthorizationUtil.get().getSystem()) {
            throw new InsufficientException("只有系统管理员才可以创建角色");
        }
        return roleHandler.modifyRole(id, role);
    }

    @ApiOperation("删除角色")
    @ApiResponses({
            @ApiResponse(code = 201, message = "创建成功")
    })
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRole(@PathVariable(name = "id") String id) {
        if (!AuthorizationUtil.get().getSystem()) {
            throw new InsufficientException("只有系统管理员才可以创建角色");
        }
        roleHandler.removeRole(id);
    }
}
