package com.wenyu7980.basic.service.organization.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
@ApiModel(description = "部门创建")
public class DepartmentAdd {
    @ApiModelProperty(name = "部门名称", required = true)
    @NotEmpty
    @Size(max = 255, min = 2)
    private String name;
    @ApiModelProperty(name = "上级部门id")
    private String parentId;
    @ApiModelProperty(name = "管理员id")
    private String adminId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
