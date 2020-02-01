package com.wenyu7980.basic.service.common.dictionary.service.impl;

import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.common.dictionary.entity.DictionaryEntity;
import com.wenyu7980.basic.service.common.dictionary.repository.DictionaryRepo;
import com.wenyu7980.basic.service.common.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-01-31 
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryRepo repo;

    @Override
    public DictionaryEntity findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("字典{0}不存在", id));
    }

    @Override
    public DictionaryEntity save(DictionaryEntity entity) {
        return repo.save(entity);
    }

    @Override
    public void delete(DictionaryEntity entity) {
        repo.delete(entity);
    }

    @Override
    public List<DictionaryEntity> findBySystemFlag(Boolean systemFlag) {
        return repo.findBySystemFlag(systemFlag);
    }
}
