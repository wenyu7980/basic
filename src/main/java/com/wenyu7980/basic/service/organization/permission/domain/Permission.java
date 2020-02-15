package com.wenyu7980.basic.service.organization.permission.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

/**
 * 权限
 * @author wenyu
 * @date 2020-02-07 
 */
@ApiModel(description = "权限")
public class Permission {
    @ApiModelProperty(name = "请求方法", required = true)
    @NotEmpty
    private String method;
    @ApiModelProperty(name = "路径", required = true)
    @NotEmpty
    private String path;
    @ApiModelProperty(name = "权限名", readOnly = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Permission that = (Permission) object;
        return Objects.equals(method, that.method) && Objects
                .equals(path, that.path) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, path, name);
    }
}
