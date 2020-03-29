package com.wenyu7980.basic.authorization.controller;

import com.wenyu7980.basic.authorization.annotation.AuthRequest;
import com.wenyu7980.basic.authorization.handler.LogoutHandler;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wenyu
 * @date 2020-02-11 
 */
@Api(tags = "退出")
@RestController
@RequestMapping("logout")
public class LogoutController {
    @Autowired
    private LogoutHandler logoutHandler;

    @ApiOperation("退出")
    @ApiResponses({
            @ApiResponse(code = 204, message = "成功")
    })
    @DeleteMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @AuthRequest(required = false)
    public void logout(
            @ApiParam("token") @RequestHeader("token") String token) {
        logoutHandler.logout(token);
    }
}
