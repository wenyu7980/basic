package com.wenyu7980.basic.service.organization.rolepermission.service;

import com.wenyu7980.basic.common.service.CommonService;
import com.wenyu7980.basic.service.organization.rolepermission.entity.RoleEntity;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
public interface RoleService extends CommonService<RoleEntity, String> {
    /**
     * 删除
     * @param entity
     */
    void delete(RoleEntity entity);
}