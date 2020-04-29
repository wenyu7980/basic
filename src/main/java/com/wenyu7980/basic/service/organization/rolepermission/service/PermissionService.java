package com.wenyu7980.basic.service.organization.rolepermission.service;

import com.wenyu7980.basic.common.service.CommonService;
import com.wenyu7980.basic.service.organization.rolepermission.entity.PermissionEntity;
import com.wenyu7980.basic.service.organization.rolepermission.entity.PermissionKey;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
public interface PermissionService
        extends CommonService<PermissionEntity, PermissionKey> {
    /**
     * 通过method查询
     * @param method
     * @return
     */
    List<PermissionEntity> findByMethod(String method);

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    Set<PermissionEntity> findByUserId(String userId);

    /**
     * 查询
     * @param method
     * @param path
     * @return
     */
    PermissionEntity findByMethodAndPath(String method, String path);

    /**
     * 查询全部
     * @return
     */
    Set<PermissionEntity> findAll();

    /**
     * 删除
     * @param iterable
     */
    void deleteAll(Iterable<PermissionEntity> iterable);

    /**
     * 保存
     * @param iterable
     * @return
     */
    List<PermissionEntity> saveAll(Iterable<PermissionEntity> iterable);

}
