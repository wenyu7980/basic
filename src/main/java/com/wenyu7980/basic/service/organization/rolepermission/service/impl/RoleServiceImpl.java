package com.wenyu7980.basic.service.organization.rolepermission.service.impl;

import com.wenyu7980.basic.common.query.QueryService;
import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.organization.rolepermission.entity.RoleEntity;
import com.wenyu7980.basic.service.organization.rolepermission.repository.RoleRepo;
import com.wenyu7980.basic.service.organization.rolepermission.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Service
public class RoleServiceImpl extends QueryService<RoleEntity>
        implements RoleService {
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

    @Override
    public void delete(RoleEntity entity) {
        roleRepo.delete(entity);
    }

    @Override
    public List<RoleEntity> findByUserId(String id) {
        return roleRepo.findByUserId(id);
    }
}
