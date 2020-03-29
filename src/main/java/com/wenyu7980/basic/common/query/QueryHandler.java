package com.wenyu7980.basic.common.query;

<<<<<<< HEAD
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
=======
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
>>>>>>> master
    @Autowired
    private QueryService<E> queryService;

    /**
<<<<<<< HEAD
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
=======
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
>>>>>>> master
}
