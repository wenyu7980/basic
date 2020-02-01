package com.wenyu7980.basic.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 数据分页
 * @author wenyu
 * @date 2020-01-31 
 */
@ApiModel(description = "数据分页")
public class PageBody<T> {
    @ApiModelProperty(name = "数据条数", readOnly = true)
    private Long count;
    @ApiModelProperty(name = "数据页数", readOnly = true)
    private Long page;
    @ApiModelProperty(name = "数据", readOnly = true)
    private List<T> data;

    public PageBody(Long count, Long page, List<T> data) {
        this.count = count;
        this.page = page;
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public Long getPage() {
        return page;
    }

    public List<T> getData() {
        return data;
    }
}
