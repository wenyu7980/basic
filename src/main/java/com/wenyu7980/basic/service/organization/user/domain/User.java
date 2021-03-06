package com.wenyu7980.basic.service.organization.user.domain;

import com.wenyu7980.basic.common.auditing.domain.AuditingDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户
 * @author wenyu
 * @date 2020-01-26 
 */
@ApiModel(description = "用户")
public class User extends AuditingDomain {
    @ApiModelProperty(value = "用户id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(value = "用户名", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String username;
    @ApiModelProperty(value = "用户名称", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String name;
    @ApiModelProperty(value = "系统管理员", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private Boolean system;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }
}
