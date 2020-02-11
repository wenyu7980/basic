package com.wenyu7980.basic.service.organization.role.controller;

import com.wenyu7980.basic.common.query.PageBody;
import com.wenyu7980.basic.service.organization.role.domain.RoleDetail;
import com.wenyu7980.basic.service.organization.role.domain.RoleListDetail;
import com.wenyu7980.basic.service.organization.role.handler.impl.RoleQueryHandler;
import com.wenyu7980.query.QueryLogic;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wenyu
 * @date 2020-02-10 
 */
@Api(tags = "角色权限管理")
@RestController
@RequestMapping("roles")
public class RoleQueryController {
    @Autowired
    private RoleQueryHandler queryHandler;

    @ApiOperation("查询角色")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功")
    })
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public RoleDetail getRole(@ApiParam("id") @PathVariable("id") String id,
            @ApiParam(name = "是否查询详情", example = "false", required = false) @RequestParam(value = "detail", required = false, defaultValue = "false") boolean detail) {

        return this.queryHandler.getOne(id, detail);
    }

    @ApiOperation("查询角色列表")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageBody<RoleListDetail> getRoles(
            @ApiParam(name = "页码", example = "0", required = false) @RequestParam(value = "index", required = false, defaultValue = "0") Integer index,
            @ApiParam(name = "页大小", example = "20", required = false) @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
            @ApiParam(name = "是否查询详情", example = "false", required = false) @RequestParam(value = "detail", required = false, defaultValue = "false") boolean detail) {
        Pageable pageable = PageRequest
                .of(index, size, Sort.Direction.DESC, "createdDateTime");
        return queryHandler.getPage(QueryLogic.and(), pageable, detail);
    }
}
