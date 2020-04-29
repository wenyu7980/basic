package com.wenyu7980.basic.service.organization.rolepermission.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-04-29 
 */
@ApiModel(description = "角色菜单操作")
public class RoleMenuOperator {
    @ApiModelProperty(value = "菜单", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Set<String> menus;
    @ApiModelProperty(value = "操作", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Set<String> operators;

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
