package com.wenyu7980.basic.service.organization.rolepermission.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
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
    @Valid
    private Set<Permission> permissions;
    @ApiModelProperty(name = "菜单code", required = true)
    @NotNull
    private Set<String> menuCodes = new HashSet<>();
    @ApiModelProperty(name = "操作code", required = true)
    @NotNull
    private Set<String> operatorCodes = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
