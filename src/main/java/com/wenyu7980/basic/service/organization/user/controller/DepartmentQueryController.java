package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.common.query.PageBody;
import com.wenyu7980.basic.service.organization.user.domain.DepartmentDetail;
import com.wenyu7980.basic.service.organization.user.domain.DepartmentListDetail;
import com.wenyu7980.basic.service.organization.user.handler.DepartmentQueryHandler;
import com.wenyu7980.query.QueryCompare;
import com.wenyu7980.query.QueryCondition;
import com.wenyu7980.query.QueryJoin;
import com.wenyu7980.query.QueryLogic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wenyu
 * @date 2020-02-14 
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("departments")
public class DepartmentQueryController {
    @Autowired
    private DepartmentQueryHandler queryHandler;

    @ApiOperation("部门查询")
    @GetMapping()
    public PageBody<DepartmentListDetail> getDepartments(
            @ApiParam("管理员id") @RequestParam(required = false) String adminId,
            @ApiParam("员工id") @RequestParam(required = false) String userId,
            @ApiParam("上级部门id") @RequestParam(required = false) String parentId,
            @ApiParam("页码") @RequestParam(defaultValue = "0") Integer index,
            @ApiParam("页大小") @RequestParam(defaultValue = "20") Integer size,
            @ApiParam("是否查询详情") @RequestParam(defaultValue = "false") boolean detail) {
        return queryHandler.getPage(QueryLogic.and(
                // 管理员
                QueryJoin.join("admin",
                        QueryCondition.of("id", QueryCompare.EQ, adminId)),
                // 用户
                QueryJoin.join("users",
                        QueryCondition.of("id", QueryCompare.EQ, userId)),
                // 上级部门id
                QueryJoin.join("parent",
                        QueryCondition.of("id", QueryCompare.EQ, parentId))),
                PageRequest.of(index, size, Sort.Direction.DESC,
                        "createdDateTime"), detail);
    }

    @ApiOperation("部门查询")
    @GetMapping("{id}")
    public DepartmentDetail getDepartment(
            @ApiParam("部门id") @PathVariable("id") String id,
            @ApiParam("是否查询详情") @RequestParam(defaultValue = "false") boolean detail) {
        return queryHandler.getOne(id, detail);
    }
}
