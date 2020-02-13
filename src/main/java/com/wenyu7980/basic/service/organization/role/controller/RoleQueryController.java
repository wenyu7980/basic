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
@Api(tags = "角色管理")
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
            @ApiParam("是否查询详情") @RequestParam(value = "detail", defaultValue = "false") boolean detail) {
        return this.queryHandler.getOne(id, detail);
    }

    @ApiOperation("查询角色列表")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageBody<RoleListDetail> getRoles(
            @ApiParam("页码") @RequestParam(value = "index", defaultValue = "0") Integer index,
            @ApiParam("页大") @RequestParam(value = "size", defaultValue = "20") Integer size,
            @ApiParam("是否查询详情") @RequestParam(value = "detail", defaultValue = "false") boolean detail) {
        Pageable pageable = PageRequest
                .of(index, size, Sort.Direction.DESC, "createdDateTime");
        return queryHandler.getPage(QueryLogic.and(), pageable, detail);
    }
}
