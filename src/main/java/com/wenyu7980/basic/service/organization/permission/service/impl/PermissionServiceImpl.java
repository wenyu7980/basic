package com.wenyu7980.basic.service.organization.permission.service.impl;

import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.organization.permission.entity.PermissionEntity;
import com.wenyu7980.basic.service.organization.permission.repository.PermissionRepo;
import com.wenyu7980.basic.service.organization.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepo permissionRepo;

    @Override
    public PermissionEntity findById(String id) {
        return permissionRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("权限{0}不存在", id));
    }

    @Override
    public PermissionEntity save(PermissionEntity entity) {
        return permissionRepo.save(entity);
    }

    @Override
    public List<PermissionEntity> findByMethod(String method) {
        return permissionRepo.findByMethod(method);
    }

    @Override
    public Set<PermissionEntity> findByUserId(String userId) {
        return permissionRepo.findByRolesUsersId(userId);
    }
}
