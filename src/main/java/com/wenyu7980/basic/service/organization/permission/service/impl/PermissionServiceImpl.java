package com.wenyu7980.basic.service.organization.permission.service.impl;

import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.organization.permission.entity.PermissionEntity;
import com.wenyu7980.basic.service.organization.permission.entity.PermissionKey;
import com.wenyu7980.basic.service.organization.permission.repository.PermissionRepo;
import com.wenyu7980.basic.service.organization.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
    public PermissionEntity findById(PermissionKey permissionKey) {
        return permissionRepo.findById(permissionKey).orElseThrow(
                () -> new NotFoundException("权限{0}-{1}不存在",
                        permissionKey.getMethod(), permissionKey.getPath()));
    }

    @Override
    public PermissionEntity save(PermissionEntity entity) {
        return permissionRepo.save(entity);
    }

    @Override
    public List<PermissionEntity> findByMethod(String method) {
        return permissionRepo.findByKeyMethod(method);
    }

    @Override
    public Set<PermissionEntity> findByUserId(String userId) {
        return permissionRepo.findByRolesUsersId(userId);
    }

    @Override
    public PermissionEntity findByMethodAndPath(String method, String path) {
        return this.findById(new PermissionKey(method, path));
    }

    @Override
    public Set<PermissionEntity> findAll() {
        return new HashSet<>(permissionRepo.findAll());
    }

    @Override
    public void deleteAll(Iterable<PermissionEntity> iterable) {
        permissionRepo.deleteAll(iterable);
    }

    @Override
    public List<PermissionEntity> saveAll(Iterable<PermissionEntity> iterable) {
        return permissionRepo.saveAll(iterable);
    }
}
