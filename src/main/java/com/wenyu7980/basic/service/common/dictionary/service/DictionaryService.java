package com.wenyu7980.basic.service.common.dictionary.service;

import com.wenyu7980.basic.common.service.CommonService;
import com.wenyu7980.basic.service.common.dictionary.entity.DictionaryEntity;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-01-31 
 */
public interface DictionaryService
        extends CommonService<DictionaryEntity, String> {
    /**
     * 删除
     * @param entity
     */
    void delete(DictionaryEntity entity);

    /**
     * 查询字典
     * @param systemFlag
     * @return
     */
    List<DictionaryEntity> findBySystemFlag(Boolean systemFlag);
}
