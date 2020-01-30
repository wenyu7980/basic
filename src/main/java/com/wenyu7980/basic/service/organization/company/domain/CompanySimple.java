package com.wenyu7980.basic.service.organization.company.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 公司简要
 * @author wenyu
 * @date 2020-01-29 
 */
@ApiModel(description = "公司简要")
public class CompanySimple {
    @ApiModelProperty(name = "公司id", readOnly = true)
    private String id;
    @ApiModelProperty(name = "公司名称", readOnly = true)
    private String name;

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
}
