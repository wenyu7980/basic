package com.wenyu7980.basic.authorization.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
@ApiModel(description = "登录信息")
public class Login {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
