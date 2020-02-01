package com.wenyu7980.basic.service.organization.user.domain;

import com.wenyu7980.basic.common.auditing.domain.AuditingDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户
 * @author wenyu
 * @date 2020-01-26 
 */
@ApiModel(description = "用户")
public class User extends AuditingDomain {
    @ApiModelProperty(value = "用户id", readOnly = true)
    private String id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户密码")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
