package com.wenyu7980.basic.service.organization.role.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@ApiModel(description = "角色")
public class RoleAdd {
    @ApiModelProperty(name = "角色名", required = true)
    @NotEmpty
    private String name;
    @ApiModelProperty(name = "权限code", required = true)
    @NotEmpty
    private Set<String> permissionCodes;
    @ApiModelProperty(name = "菜单code", required = true)
    @NotEmpty
    private Set<String> menuCodes;
    @ApiModelProperty(name = "操作code", required = true)
    @NotEmpty
    private Set<String> operatorCodes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getPermissionCodes() {
        return permissionCodes;
    }

    public void setPermissionCodes(Set<String> permissionCodes) {
        this.permissionCodes = permissionCodes;
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
