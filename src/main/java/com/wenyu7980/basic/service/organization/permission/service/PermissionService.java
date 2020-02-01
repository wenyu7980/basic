package com.wenyu7980.basic.service.organization.permission.service;

import com.wenyu7980.basic.common.service.CommonService;
import com.wenyu7980.basic.service.organization.permission.entity.PermissionEntity;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
public interface PermissionService
        extends CommonService<PermissionEntity, String> {
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
}
