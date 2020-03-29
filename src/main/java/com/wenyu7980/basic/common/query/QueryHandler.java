package com.wenyu7980.basic.common.query;

import com.wenyu7980.query.QueryPredicateExpress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 查询
 * @author: wenyu
 * @date:2020/3/23
 */
public abstract class QueryHandler<E, L> {
    @Autowired
    private QueryService<E> queryService;

    /**
     * 排序查询
     * @param express
     * @param sort
     * @param detailFlag
     * @return
     */
    public List<L> getAll(final QueryPredicateExpress express, final Sort sort,
            final boolean detailFlag) {
        return queryService.findAll(express).stream()
                .map(e -> this.mapList(e, detailFlag))
                .collect(Collectors.toList());
    }

    /**
     * 分页查询
     * @param express
     * @param pageable
     * @param detailFlag
     * @return
     */
    public PageBody<L> getAll(final QueryPredicateExpress express,
            final Pageable pageable, final boolean detailFlag) {
        return PageBody.of(queryService.findAll(express, pageable),
                e -> this.mapList(e, detailFlag));
    }

    /**
     * 查询全部
     * @param express
     * @param detailFlag
     * @return
     */
    public List<L> getAll(final QueryPredicateExpress express,
            final boolean detailFlag) {
        return queryService.findAll(express).stream()
                .map(e -> this.mapList(e, detailFlag))
                .collect(Collectors.toList());
    }

    /**
     * 个数
     * @param express
     * @return
     */
    public long count(QueryPredicateExpress express) {
        return queryService.count(express);
    }

    /**
     * 转换list
     * @param entity
     * @param detailFlag
     * @return
     */
    protected abstract L mapList(E entity, boolean detailFlag);
}
