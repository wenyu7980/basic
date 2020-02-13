package com.wenyu7980.basic.service.organization.company.domain;

import com.wenyu7980.basic.common.auditing.domain.AuditingDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
@ApiModel(description = "公司信息")
public class Company extends AuditingDomain {
    @ApiModelProperty(name = "公司id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(name = "公司名称", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
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
