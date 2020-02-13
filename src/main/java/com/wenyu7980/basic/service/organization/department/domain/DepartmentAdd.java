package com.wenyu7980.basic.service.organization.department.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

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
    @ApiModelProperty(name = "管理员id")
    @NotEmpty
    private Set<String> adminIds = new HashSet<>();
    @ApiModelProperty(name = "公司id", required = true)
    @NotEmpty
    private String companyId;
    @ApiModelProperty(name = "上级部门id")
    private String parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getAdminIds() {
        return adminIds;
    }

    public void setAdminIds(Set<String> adminIds) {
        this.adminIds = adminIds;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
