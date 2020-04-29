package com.wenyu7980.basic.service.organization.rolepermission.domain;

import com.wenyu7980.basic.common.auditing.domain.AuditingDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色
 * @author wenyu
 * @date 2020-01-26 
 */
@ApiModel(description = "角色")
public class Role extends AuditingDomain {
    @ApiModelProperty(name = "角色id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(name = "角色名", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
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
