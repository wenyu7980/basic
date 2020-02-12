package com.wenyu7980.basic.service.organization.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author wenyu
 * @date 2020-02-12 
 */
@ApiModel(description = "用户密码")
public class UserPassword {
    @ApiModelProperty(name = "旧密码", required = true)
    @NotEmpty
    @Size(min = 6, max = 18)
    private String oldPassword;
    @ApiModelProperty(name = "新密码", required = true)
    @NotEmpty
    @Size(min = 6, max = 18)
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
