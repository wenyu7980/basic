package com.wenyu7980.basic.authorization.domain;

import com.wenyu7980.basic.service.organization.user.domain.DepartmentSimple;
import com.wenyu7980.basic.service.organization.user.domain.UserSimple;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * 登录结果
 * @author wenyu
 * @date 2020-01-28 
 */
@ApiModel(description = "登录结果")
public class LoginResult {
    @ApiModelProperty(value = "请求头Token", readOnly = true)
    private String headerToken;
    @ApiModelProperty(value = "请求参数Token", readOnly = true)
    private String queryToken;
    @ApiModelProperty(value = "用户信息", readOnly = true)
    private UserSimple user;
    @ApiModelProperty(value = "系统管理员", readOnly = true)
    private Boolean system;
    @ApiModelProperty(value = "部门信息", readOnly = true)
    private DepartmentSimple department;
    @ApiModelProperty(value = "最后登录时间", readOnly = true)
    private LocalDateTime latestLoginDateTime;

    public Boolean getSystem() {
        return system;
    }

    public void setHeaderToken(String headerToken) {
        this.headerToken = headerToken;
    }

    public void setQueryToken(String queryToken) {
        this.queryToken = queryToken;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

    public String getHeaderToken() {
        return headerToken;
    }

    public String getQueryToken() {
        return queryToken;
    }

    public UserSimple getUser() {
        return user;
    }

    public void setUser(UserSimple user) {
        this.user = user;
    }

    public DepartmentSimple getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentSimple department) {
        this.department = department;
    }

    public LocalDateTime getLatestLoginDateTime() {
        return latestLoginDateTime;
    }

    public void setLatestLoginDateTime(LocalDateTime latestLoginDateTime) {
        this.latestLoginDateTime = latestLoginDateTime;
    }
}
