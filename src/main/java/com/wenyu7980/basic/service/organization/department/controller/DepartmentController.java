package com.wenyu7980.basic.service.organization.department.controller;

import com.wenyu7980.basic.service.organization.department.domain.Department;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentAdd;
import com.wenyu7980.basic.service.organization.department.handler.DepartmentHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 部门
 * @author wenyu
 * @date 2020-01-28 
 */
@Api(tags = "部门管理")
@RestController
@RequestMapping(path = "departments")
public class DepartmentController {
    @Autowired
    private DepartmentHandler departmentHandler;

    @ApiOperation("创建部门")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department addDepartment(
            @RequestBody @Valid DepartmentAdd department) {
        return departmentHandler.addDepartment(department);
    }

    @ApiOperation("删除部门")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeDepartment(
            @ApiParam("部门id") @PathVariable("id") String id) {
        departmentHandler.remove(id);
    }

    @ApiOperation("修改部门")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Department modify(@ApiParam("部门id") @PathVariable("id") String id,
            @RequestBody @Valid DepartmentAdd departmentAdd) {
        return departmentHandler.modify(id, departmentAdd);
    }
}
