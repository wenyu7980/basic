package com.wenyu7980.basic.service.organization.permission.controller;

import com.wenyu7980.basic.service.organization.permission.domain.Permission;
import com.wenyu7980.basic.service.organization.permission.handler.PermissionQueryHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Api(tags = "角色权限管理")
@RestController
@RequestMapping("permissions")
public class PermissionQueryController {
    @Autowired
    private PermissionQueryHandler queryHandler;

    @ApiOperation("权限列表查询")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功")
    })
    @GetMapping()
    @ResponseStatus(code = HttpStatus.OK)
    public List<Permission> getPermission() {
        return queryHandler.getPermissions();
    }
}
