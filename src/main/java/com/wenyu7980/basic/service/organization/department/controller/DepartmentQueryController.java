package com.wenyu7980.basic.service.organization.department.controller;

import com.wenyu7980.basic.common.query.PageBody;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentDetail;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentListDetail;
import com.wenyu7980.basic.service.organization.department.handler.impl.DepartmentQueryHandler;
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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wenyu
 * @date 2020-02-14 
 */
@Api(tags = "部门管理")
@RestController
@RequestMapping("departments")
public class DepartmentQueryController {
    @Autowired
    private DepartmentQueryHandler queryHandler;

    @ApiOperation("部门查询")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public PageBody<DepartmentListDetail> getDepartments(
            @ApiParam("管理员id") @RequestParam(value = "adminId", required = false) String adminId,
            @ApiParam("员工id") @RequestParam(value = "userId", required = false) String userId,
            @ApiParam("上级部门id") @RequestParam(value = "parentId", required = false) String parentId,
            @ApiParam("页码") @RequestParam(value = "index", defaultValue = "0") Integer index,
            @ApiParam("页大小") @RequestParam(value = "size", defaultValue = "20") Integer size,
            @ApiParam("是否查询详情") @RequestParam(value = "detail", defaultValue = "false") boolean detail) {
        return queryHandler.getPage(QueryLogic.and(QueryJoin.join("admins",
                QueryCondition.of("id", QueryCompare.EQ, adminId)), QueryJoin
                        .join("users",
                                QueryCondition.of("id", QueryCompare.EQ, userId)),
                QueryJoin.join("parent",
                        QueryCondition.of("id", QueryCompare.EQ, parentId))),
                PageRequest.of(index, size, Sort.Direction.DESC,
                        "createdDateTime"), detail);
    }

    @ApiOperation("部门查询")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public DepartmentDetail getDepartment(
            @ApiParam("部门id") @PathVariable("id") String id,
            @ApiParam("是否查询详情") @RequestParam(value = "detail", defaultValue = "false") boolean detail) {
        return queryHandler.getOne(id, detail);
    }
}
