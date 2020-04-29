package com.wenyu7980.basic.service.organization.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 部门简要
 * @author wenyu
 * @date 2020-01-29 
 */
@ApiModel(description = "部门简要")
public class DepartmentSimple {
    @ApiModelProperty(value = "部门id", readOnly = true)
    private String id;
    @ApiModelProperty(value = "部门名称", readOnly = true)
    private String name;
    @ApiModelProperty(value = "公司id", readOnly = true)
    private String companyId;
    @ApiModelProperty(value = "公司名称", readOnly = true)
    private String companyName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
