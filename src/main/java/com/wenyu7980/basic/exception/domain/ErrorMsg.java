package com.wenyu7980.basic.exception.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 错误信息
 * @author wenyu
 * @date 2020-01-28 
 */
@ApiModel(description = "错误信息")
public class ErrorMsg {
    @ApiModelProperty(name = "错误码", readOnly = true)
    private int code;
    @ApiModelProperty(name = "错误信息", readOnly = true)
    private String message;

    public ErrorMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
