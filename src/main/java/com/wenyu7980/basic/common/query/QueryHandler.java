package com.wenyu7980.basic.common.query;

import com.wenyu7980.basic.common.service.CommonService;
import com.wenyu7980.query.QueryPredicateExpress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

/**
 * 查询
 * 只适用于id为String类型的实体类查询
 * @author wenyu
 * @date 2020-02-11 
 */
public abstract class QueryHandler<E, L, D> {
    @Autowired
    private CommonService<E, String> commonService;
    @Autowired
    private QueryService<E> queryService;

    /**
     * 查询分页
     * @param express
     * @param pageable
     * @param detail
     * @return
     */
    public PageBody<L> getPage(QueryPredicateExpress express, Pageable pageable,
            boolean detail) {
        return PageBody.of(queryService.findAll(express, pageable),
                e -> this.mapListDetail(e, detail));
    }

    /**
     * 查询单个
     * @param id
     * @param detail
     * @return
     */
    public D getOne(String id, boolean detail) {
        return this.mapDetail(commonService.findById(id), detail);
    }

    protected abstract L mapListDetail(E entity, boolean detailFlag);

    protected abstract D mapDetail(E entity, boolean detailFlag);
}
