package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.authorization.annotation.AuthRequest;
import com.wenyu7980.basic.common.query.PageBody;
import com.wenyu7980.basic.common.query.QuerySearch;
import com.wenyu7980.basic.common.query.QuerySearchName;
import com.wenyu7980.basic.common.query.QuerySearchUtil;
import com.wenyu7980.basic.service.organization.user.domain.UserDetail;
import com.wenyu7980.basic.service.organization.user.domain.UserListDetail;
import com.wenyu7980.basic.service.organization.user.handler.UserQueryHandler;
import com.wenyu7980.query.QueryCompare;
import com.wenyu7980.query.QueryCondition;
import com.wenyu7980.query.QueryLogic;
import com.wenyu7980.query.QueryPredicateExpress;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功"),
            @ApiResponse(code = 404, message = "不存在")
    })
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public UserDetail getUser(
            @ApiParam(name = "用户id") @PathVariable("id") String id,
            @ApiParam(name = "是否查询详情", example = "false", required = false) @RequestParam(value = "detail", required = false, defaultValue = "false") boolean detail) {
        return queryHandler.getUser(id, detail);
    }

    @ApiOperation("用户列表查询")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public PageBody<UserListDetail> getUsers(
            @ApiParam(name = "页码", example = "0", required = false) @RequestParam(value = "index", required = false, defaultValue = "0") Integer index,
            @ApiParam(name = "页大小", example = "20", required = false) @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
            @ApiParam(name = "是否查询详情", example = "false", required = false) @RequestParam(value = "detail", required = false, defaultValue = "false") boolean detail) {
        return queryHandler.getUsers(QueryLogic.and(), PageRequest
                        .of(index, size, Sort.Direction.DESC, "updatedDateTime"),
                detail);
    }

    @ApiOperation("用户列表查询")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功")
    })
    @PostMapping(path = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    @AuthRequest(required = false)
    public PageBody<UserListDetail> searchUsers(
            @ApiParam(name = "页码", example = "0", required = false) @RequestParam(value = "index", required = false, defaultValue = "0") Integer index,
            @ApiParam(name = "页大小", example = "20", required = false) @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
            @ApiParam(name = "是否查询详情", example = "false", required = false) @RequestParam(value = "detail", required = false, defaultValue = "false") boolean detail,
            @RequestBody @Valid QuerySearch<UserSearchName> search) {
        QueryPredicateExpress express = QuerySearchUtil
                .toPredicateExpress(search);
        return queryHandler.getUsers(express, PageRequest
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
