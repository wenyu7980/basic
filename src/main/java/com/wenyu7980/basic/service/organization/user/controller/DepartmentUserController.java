package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.service.organization.user.domain.Department;
import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.handler.DepartmentUserHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-02-14 
 */
@Api(tags = { "用户管理" })
@RestController
@RequestMapping("departments")
public class DepartmentUserController {
    @Autowired
    private DepartmentUserHandler departmentUserHandler;

    @ApiOperation("查询部门员工")
    @GetMapping("{id}/users")
    public List<User> getUser(@ApiParam("部门id") @PathVariable("id") String id) {
        return departmentUserHandler.getUserByDepartment(id);
    }

    @ApiOperation("修改部门员工")
    @PutMapping("{id}/users")
    public Department modifyUser(
            @ApiParam("部门id") @PathVariable("id") String id,
            @RequestBody Set<String> userIds) {
        return departmentUserHandler.modifyUser(id, userIds);
    }
}
