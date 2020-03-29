package com.wenyu7980.basic.service.organization.department.controller;

import com.wenyu7980.basic.service.organization.department.domain.Department;
import com.wenyu7980.basic.service.organization.department.handler.DepartmentUserHandler;
import com.wenyu7980.basic.service.organization.user.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-02-14 
 */
@Api(tags = { "部门管理", "部门用户管理" })
@RestController
@RequestMapping("departments")
public class DepartmentUserController {
    @Autowired
    private DepartmentUserHandler departmentUserHandler;

    @ApiOperation("查询部门员工")
    @GetMapping("{id}/users")
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> getUser(@ApiParam("部门id") @PathVariable("id") String id) {
        return departmentUserHandler.getUserByDepartment(id);
    }

    @ApiOperation("修改部门员工")
    @PutMapping("{id}/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Department modifyUser(
            @ApiParam("部门id") @PathVariable("id") String id,
            @RequestBody Set<String> userIds) {
        return departmentUserHandler.modifyUser(id, userIds);
    }

    @ApiOperation("查询部门管理员")
    @GetMapping("{id}/admins")
    @ResponseStatus(HttpStatus.CREATED)
    public List<User> getAdmin(
            @ApiParam("部门id") @PathVariable("id") String id) {
        return departmentUserHandler.getAdminByDepartment(id);
    }

    @ApiOperation("修改部门管理员")
    @PutMapping("{id}/admins")
    @ResponseStatus(HttpStatus.CREATED)
    public Department modifyAdmin(
            @ApiParam("部门id") @PathVariable("id") String id,
            @RequestBody Set<String> userIds) {
        return departmentUserHandler.modifyAdmin(id, userIds);
    }
}
