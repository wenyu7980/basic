package com.wenyu7980.basic.authorization.controller;

import com.wenyu7980.basic.authorization.annotation.AuthRequest;
import com.wenyu7980.basic.authorization.domain.Login;
import com.wenyu7980.basic.authorization.domain.LoginResult;
import com.wenyu7980.basic.authorization.handler.LoginHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 登录
 * @author wenyu
 * @date 2020-01-28 
 */
@Api(tags = "登录")
@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginHandler loginHandler;

    /**
     * 登录
     * @return
     */
    @ApiOperation("登录")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @AuthRequest(required = false)
    public LoginResult login(@RequestBody @Valid Login login) {
        return loginHandler.login(login);
    }
}
