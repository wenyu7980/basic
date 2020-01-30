package com.wenyu7980.basic.service.organization.role.service.impl;

import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.organization.role.entity.RoleEntity;
import com.wenyu7980.basic.service.organization.role.repository.RoleRepo;
import com.wenyu7980.basic.service.organization.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public RoleEntity findById(String id) {
        return roleRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("角色{0}不存在", id));
    }

    @Override
    public RoleEntity save(RoleEntity entity) {
        return roleRepo.save(entity);
    }
}
