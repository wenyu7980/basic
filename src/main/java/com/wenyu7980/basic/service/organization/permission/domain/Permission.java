package com.wenyu7980.basic.service.organization.permission.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 权限
 * @author wenyu
 * @date 2020-02-07 
 */
@ApiModel(description = "权限")
public class Permission {
    @ApiModelProperty(name = "权限code", readOnly = true)
    private String code;
    @ApiModelProperty(name = "权限名", readOnly = true)
    private String name;
    @ApiModelProperty(name = "请求方法", allowableValues = "POST,GET,HEAD,DELETE,PUT", readOnly = true)
    private String method;
    @ApiModelProperty(name = "路径", readOnly = true)
    private String path;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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
}
