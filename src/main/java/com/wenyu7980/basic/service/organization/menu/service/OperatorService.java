package com.wenyu7980.basic.service.organization.menu.service;

import com.wenyu7980.basic.common.service.CommonService;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorEntity;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorKey;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
public interface OperatorService
        extends CommonService<OperatorEntity, OperatorKey> {
    /**
     * 保存
     * @param entities
     * @return
     */
    List<OperatorEntity> saveAll(List<OperatorEntity> entities);

    /**
     * 通过用户id查询
     * @param userId
     * @return
     */
    List<OperatorEntity> findByUserId(String userId);
}
