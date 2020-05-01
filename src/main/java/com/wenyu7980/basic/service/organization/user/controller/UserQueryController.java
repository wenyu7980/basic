package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.common.query.PageBody;
import com.wenyu7980.basic.common.query.logic.QuerySearch;
import com.wenyu7980.basic.common.query.logic.QuerySearchName;
import com.wenyu7980.basic.common.query.logic.QuerySearchUtil;
import com.wenyu7980.basic.service.organization.user.domain.UserDetail;
import com.wenyu7980.basic.service.organization.user.domain.UserListDetail;
import com.wenyu7980.basic.service.organization.user.handler.UserQueryHandler;
import com.wenyu7980.query.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
public class UserQueryController {
    @Autowired
    private UserQueryHandler queryHandler;

    @ApiOperation("用户查询")
    @GetMapping(path = "{id}")
    public UserDetail getUser(@ApiParam("用户id") @PathVariable("id") String id,
            @ApiParam("是否查询详情") @RequestParam(value = "detail", defaultValue = "false") boolean detail) {

        return queryHandler.getOne(id, detail);
    }

    @ApiOperation("用户列表查询")
    @GetMapping()
    public PageBody<UserListDetail> getUsers(
            @ApiParam("所属部门id") @RequestParam(value = "departmentId", required = false) String departmentId,
            @ApiParam("所属管理部门id") @RequestParam(value = "adminDepartmentId", required = false) String adminDepartmentId,
            @ApiParam("页码") @RequestParam(value = "index", defaultValue = "0") Integer index,
            @ApiParam("页大小") @RequestParam(value = "size", defaultValue = "20") Integer size,
            @ApiParam("是否查询详情") @RequestParam(value = "detail", defaultValue = "false") boolean detail) {
        return queryHandler.getPage(QueryLogic.and(
                // 所属部门
                QueryJoin.join("department",
                        QueryCondition.of("id", QueryCompare.EQ, departmentId)),
                // 管理部门
                QueryJoin.join("adminDepartments", QueryCondition
                        .of("id", QueryCompare.EQ, adminDepartmentId))),
                PageRequest.of(index, size, Sort.Direction.DESC,
                        "updatedDateTime"), detail);
    }

    @ApiOperation("用户列表查询")
    @PostMapping(path = "search")
    public PageBody<UserListDetail> searchUsers(
            @ApiParam("页码") @RequestParam(value = "index", defaultValue = "0") Integer index,
            @ApiParam("页大小") @RequestParam(value = "size", defaultValue = "20") Integer size,
            @ApiParam("是否查询详情") @RequestParam(value = "detail", defaultValue = "false") boolean detail,
            @RequestBody @Valid QuerySearch<UserSearchName> search) {
        QueryPredicateExpress express = QuerySearchUtil
                .toPredicateExpress(search);
        return queryHandler.getPage(express, PageRequest
                        .of(index, size, Sort.Direction.DESC, "updatedDateTime"),
                detail);
    }

    public enum UserSearchName implements QuerySearchName {
        username() {
            @Override
            public QueryPredicateExpress queryExpress(QueryCompare compare,
                    Object object) {
                return QueryCondition.of("username", compare,
                        object == null ? null : object.toString());
            }
        };
    }
}
