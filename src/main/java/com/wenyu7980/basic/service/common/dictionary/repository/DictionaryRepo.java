package com.wenyu7980.basic.service.common.dictionary.repository;

import com.wenyu7980.basic.service.common.dictionary.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-01-31 
 */
@Repository
public interface DictionaryRepo
        extends JpaRepository<DictionaryEntity, String> {
    /**
     * 查询字典
     * @param systemFlag
     * @return
     */
    List<DictionaryEntity> findBySystemFlag(Boolean systemFlag);
}
