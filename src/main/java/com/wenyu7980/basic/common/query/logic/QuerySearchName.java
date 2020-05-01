package com.wenyu7980.basic.common.query.logic;

import com.wenyu7980.query.QueryCompare;
import com.wenyu7980.query.QueryPredicateExpress;

/**
 * 检索名
 * @author wenyu
 * @date 2020-02-04 
 */
public interface QuerySearchName {
    /**
     * 转换
     * @param compare
     * @param object
     * @return
     */
    QueryPredicateExpress queryExpress(QueryCompare compare, Object object);
}
