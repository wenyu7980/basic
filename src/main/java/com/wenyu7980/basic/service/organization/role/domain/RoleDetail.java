package com.wenyu7980.basic.service.organization.role.domain;

import com.wenyu7980.basic.service.organization.permission.domain.Permission;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-02-10 
 */
@ApiModel(description = "角色详情")
public class RoleDetail extends RoleListDetail {
    @ApiModelProperty(name = "权限code", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Set<Permission> permissions;
    @ApiModelProperty(name = "菜单code", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Set<String> menuCodes;
    @ApiModelProperty(name = "操作code", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Set<String> operatorCodes;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getMenuCodes() {
        return menuCodes;
    }

    public void setMenuCodes(Set<String> menuCodes) {
        this.menuCodes = menuCodes;
    }

    public Set<String> getOperatorCodes() {
        return operatorCodes;
    }

    public void setOperatorCodes(Set<String> operatorCodes) {
        this.operatorCodes = operatorCodes;
    }
}
