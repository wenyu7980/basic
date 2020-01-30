package com.wenyu7980.basic.common;

/**
 * @author wenyu
 * @date 2020-01-26
 * @param <T>
 * @param <ID>
 */
public interface CommonService<T, ID> {
    /**
     * 通过id查询
     * @param id
     * @return
     */
    T findById(ID id);

    /**
     * 保存
     * @param entity
     * @return
     */
    T save(T entity);
}
