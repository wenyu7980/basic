package com.wenyu7980.basic.common.query.logic;

import com.wenyu7980.query.QueryLogic;
import com.wenyu7980.query.QueryPredicateExpress;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-05 
 */
public class QuerySearchUtil {
    private QuerySearchUtil() {
    }

    /**
     * 转换
     * @param search
     * @param <T>
     * @return
     */
    public static <T extends QuerySearchName> QueryPredicateExpress toPredicateExpress(
            QuerySearch<T> search) {
        if (search == null) {
            return QueryLogic.and();
        }
        List<QueryPredicateExpress> expresses = new ArrayList<>();
        // 比较项
        if (search.getItems() != null) {
            for (QuerySearchItem item : search.getItems()) {
                expresses.add(item.getName()
                        .queryExpress(item.getCompare(), item.getValue()));
            }
        }
        if (search.getSearches() != null) {
            for (QuerySearch s : search.getSearches()) {
                expresses.add(toPredicateExpress(s));
            }
        }
        if (expresses.size() > 0) {
            return search.getLogic().queryExpress(expresses);
        } else {
            return QueryLogic.and();
        }
    }
}
