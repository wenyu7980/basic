package com.wenyu7980.basic.common.query.logic;

import com.wenyu7980.basic.exception.code400.SearchBodyBadException;
import com.wenyu7980.query.QueryLogic;
import com.wenyu7980.query.QueryPredicateExpress;

import java.util.List;

/**
 * 逻辑
 * @author wenyu
 * @date 2020-02-04 
 */
public enum QuerySearchLogic {
    AND() {
        @Override
        public QueryPredicateExpress queryExpress(
                List<QueryPredicateExpress> expresses) {
            assert expresses != null;
            return QueryLogic.and(expresses);
        }
    },
    OR {
        @Override
        public QueryPredicateExpress queryExpress(
                List<QueryPredicateExpress> expresses) {
            assert expresses != null;
            return QueryLogic.or(expresses);
        }
    },
    NOT {
        @Override
        public QueryPredicateExpress queryExpress(
                List<QueryPredicateExpress> expresses) {
            assert expresses != null;
            if (expresses.size() > 1) {
                throw new SearchBodyBadException("NOT 逻辑只能有一个逻辑项或者判断项");
            }
            if (expresses.size() == 0) {
                return QueryLogic.and();
            }
            return QueryLogic.not(expresses.get(0));
        }
    },
    XOR {
        @Override
        public QueryPredicateExpress queryExpress(
                List<QueryPredicateExpress> expresses) {
            assert expresses != null;
            if (expresses.size() != 2) {
                throw new SearchBodyBadException("XOR 逻辑有且只能有两个逻辑项或者判断项");
            }
            return QueryLogic.xor(expresses.get(0), expresses.get(1));
        }
    };

    public abstract QueryPredicateExpress queryExpress(
            List<QueryPredicateExpress> expresses);}
