package com.wenyu7980.basic.service.organization.company.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
@ApiModel(description = "公司创建修改信息")
public class CompanyAdd {
    @ApiModelProperty(name = "公司名称", required = true)
    @NotEmpty
    @Size(min = 2, max = 255)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
