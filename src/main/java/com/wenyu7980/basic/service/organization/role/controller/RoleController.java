package com.wenyu7980.basic.service.organization.role.controller;

import com.wenyu7980.basic.service.organization.role.domain.Role;
import com.wenyu7980.basic.service.organization.role.domain.RoleAdd;
import com.wenyu7980.basic.service.organization.role.handler.RoleHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("roles")
public class RoleController {
    @Autowired
    private RoleHandler roleHandler;

    @ApiOperation("创建角色")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role addRole(@RequestBody @Valid RoleAdd role) {
        return roleHandler.addRole(role);
    }

    @ApiOperation("修改角色")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Role modifyRole(@PathVariable(name = "id") String id,
            @RequestBody @Valid RoleAdd role) {
        return roleHandler.modifyRole(id, role);
    }

    @ApiOperation("删除角色")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeRole(@PathVariable(name = "id") String id) {
        roleHandler.removeRole(id);
    }
}
