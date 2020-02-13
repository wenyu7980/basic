package com.wenyu7980.basic.service.organization.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

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
    @ApiModelProperty(name = "密码", required = true)
    @NotEmpty
    @Size(min = 6, max = 18)
    private String password;
    @ApiModelProperty(name = "所属部门")
    private Set<String> departmentIds = new HashSet<>();

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

    public Set<String> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(Set<String> departmentIds) {
        this.departmentIds = departmentIds;
    }
}
