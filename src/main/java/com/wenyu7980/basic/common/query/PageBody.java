package com.wenyu7980.basic.common.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 数据分页
 * @author wenyu
 * @date 2020-01-31 
 */
@ApiModel(description = "数据分页")
public class PageBody<T> {
    @ApiModelProperty(name = "数据条数", readOnly = true)
    private long count;
    @ApiModelProperty(name = "数据页数", readOnly = true)
    private int pages;
    @ApiModelProperty(name = "数据", readOnly = true)
    private List<T> data;

    public static <E, T> PageBody of(Page<E> page, Function<E, T> mapper) {
        return new PageBody<T>(page.getTotalElements(), page.getTotalPages(),
                page.getContent().stream().map(mapper)
                        .collect(Collectors.toList()));
    }

    private PageBody(long count, int pages, List<T> data) {
        this.count = count;
        this.pages = pages;
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public int getPages() {
        return pages;
    }

    public List<T> getData() {
        return data;
    }
}
