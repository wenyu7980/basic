package com.wenyu7980.basic.service.organization.user.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
@ApiModel(description = "用户简要")
public class UserSimple {
    @ApiModelProperty(value = "用户id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(value = "用户名", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String username;
    @ApiModelProperty(value = "用户名称", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String name;

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
}
