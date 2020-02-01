package com.wenyu7980.basic.service.organization.user.controller;

import com.wenyu7980.basic.common.domain.PageBody;
import com.wenyu7980.basic.service.organization.user.domain.UserListDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
@Api(tags = "用户管理")
@RequestMapping("users")
@RestController
public class UserQueryController {
    @ApiOperation("用户列表查询")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public PageBody<UserListDetail> getUsers() {
        return null;
    }

    @ApiOperation("用户列表查询")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功")
    })
    @PostMapping(path = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.OK)
    public PageBody<UserListDetail> searchUsers() {
        return null;
    }

}
