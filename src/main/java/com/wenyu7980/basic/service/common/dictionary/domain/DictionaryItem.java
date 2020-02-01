package com.wenyu7980.basic.service.common.dictionary.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典项
 * @author wenyu
 * @date 2020-01-31 
 */
@ApiModel(description = "字典项")
public class DictionaryItem {
    @ApiModelProperty(name = "字典项code")
    private String code;
    @ApiModelProperty(name = "字典名")
    private String name;

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
}
