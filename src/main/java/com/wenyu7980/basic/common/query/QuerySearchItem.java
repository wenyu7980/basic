package com.wenyu7980.basic.common.query;

import com.wenyu7980.query.QueryCompare;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 *
 * @author wenyu
 * @date 2020-02-01 
 */
@ApiModel(description = "比较项")
public class QuerySearchItem<E extends QuerySearchName> {
    @ApiModelProperty(name = "比较项名称", required = true)
    @NotNull
    private E name;
    @ApiModelProperty(name = "比较符", required = true)
    @NotNull
    private QueryCompare compare;
    @ApiModelProperty(name = "比较值:单值或者数组", required = true)
    private Object value;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public QueryCompare getCompare() {
        return compare;
    }

    public void setCompare(QueryCompare compare) {
        this.compare = compare;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
