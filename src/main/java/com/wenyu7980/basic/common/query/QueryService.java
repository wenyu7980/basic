package com.wenyu7980.basic.common.query;

import com.wenyu7980.query.QueryPredicateExpress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
public abstract class QueryService<T> {
    @Autowired
    private JpaSpecificationExecutor<T> executor;

    /**
     * 查询
     * @param express
     * @return
     */
    public List<T> findAll(QueryPredicateExpress express) {
        return this.executor.findAll(
                (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
                    return express.predicate(root, criteriaBuilder);
                });
    }

    /**
     * 查询所有
     * @param express
     * @param sort
     * @return
     */
    public List<T> findAll(QueryPredicateExpress express, Sort sort) {
        return this.executor.findAll(
                (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
                    return express.predicate(root, criteriaBuilder);
                }, sort);
    }

    /**
     * 查询分页
     * @param express
     * @param pageable
     * @return
     */
    public Page<T> findAll(QueryPredicateExpress express, Pageable pageable) {
        return this.executor.findAll(
                (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
                    return express.predicate(root, criteriaBuilder);
                }, pageable);
    }

    /**
     * 个数
     * @param express
     * @return
     */
    public long count(QueryPredicateExpress express) {
        return this.executor
                .count((Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
                    return express.predicate(root, criteriaBuilder);
                });
    }

}
