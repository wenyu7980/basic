package com.wenyu7980.basic.service.organization.menu.service.impl;

import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorEntity;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorKey;
import com.wenyu7980.basic.service.organization.menu.repository.OperatorRepo;
import com.wenyu7980.basic.service.organization.menu.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Service
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    private OperatorRepo repo;

    @Override
    public List<OperatorEntity> saveAll(List<OperatorEntity> entities) {
        return repo.saveAll(entities);
    }

    @Override
    public List<OperatorEntity> findByUserId(String userId) {
        return repo.findByRoleUsersId(userId);
    }

    @Override
    public OperatorEntity findById(OperatorKey operatorKey) {
        return repo.findById(operatorKey).orElseThrow(
                () -> new NotFoundException("操作:{0},{1}不存在",
                        operatorKey.getCode(), operatorKey.getRoleId()));
    }

    @Override
    public OperatorEntity save(OperatorEntity entity) {
        return repo.save(entity);
    }
}
