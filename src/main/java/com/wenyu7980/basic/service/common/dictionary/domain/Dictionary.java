package com.wenyu7980.basic.service.common.dictionary.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-01-31 
 */
@ApiModel(description = "字典")
public class Dictionary {
    @ApiModelProperty(name = "字典code", required = true)
    private String code;
    @ApiModelProperty(name = "字典名", required = true)
    private String name;
    @ApiModelProperty(name = "备注", required = true)
    private String remark;
    @ApiModelProperty(name = "字典项", required = true)
    private List<DictionaryItem> items;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<DictionaryItem> getItems() {
        return items;
    }

    public void setItems(List<DictionaryItem> items) {
        this.items = items;
    }
}
