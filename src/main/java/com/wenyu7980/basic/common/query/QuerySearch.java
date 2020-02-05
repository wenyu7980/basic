package com.wenyu7980.basic.common.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-04 
 */
@ApiModel(description = "检索")
public class QuerySearch<T extends QuerySearchName> {
    @ApiModelProperty(name = "逻辑条件", required = true)
    @NotNull
    private QuerySearchLogic logic;
    @ApiModelProperty(name = "逻辑项")
    private List<QuerySearch<T>> searches;
    @ApiModelProperty(name = "判断项")
    private List<QuerySearchItem<T>> items;

    public QuerySearchLogic getLogic() {
        return logic;
    }

    public void setLogic(QuerySearchLogic logic) {
        this.logic = logic;
    }

    public List<QuerySearch<T>> getSearches() {
        return searches;
    }

    public void setSearches(List<QuerySearch<T>> searches) {
        this.searches = searches;
    }

    public List<QuerySearchItem<T>> getItems() {
        return items;
    }

    public void setItems(List<QuerySearchItem<T>> items) {
        this.items = items;
    }
}
