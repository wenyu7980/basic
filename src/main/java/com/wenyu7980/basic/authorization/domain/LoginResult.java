package com.wenyu7980.basic.authorization.domain;

import com.wenyu7980.basic.service.organization.department.domain.DepartmentSimple;
import com.wenyu7980.basic.service.organization.user.domain.UserSimple;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.Set;

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
    @ApiModelProperty(value = "菜单code", readOnly = true)
    private Set<String> menus;
    @ApiModelProperty(value = "操作code", readOnly = true)
    private Set<String> operators;

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

    public Set<String> getMenus() {
        return menus;
    }

    public void setMenus(Set<String> menus) {
        this.menus = menus;
    }

    public Set<String> getOperators() {
        return operators;
    }

    public void setOperators(Set<String> operators) {
        this.operators = operators;
    }
}
