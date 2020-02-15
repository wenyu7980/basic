package com.wenyu7980.basic.service.organization.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
@ApiModel(description = "增加用户")
public class UserAdd {
    @ApiModelProperty(name = "用户名", required = true)
    @NotEmpty
    @Size(min = 6, max = 18)
    private String username;
    @ApiModelProperty(name = "用户名称", required = true)
    @NotEmpty
    @Size(min = 2, max = 8)
    private String name;
    @ApiModelProperty(name = "密码", required = true)
    @NotEmpty
    @Size(min = 6, max = 18)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
