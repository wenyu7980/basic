package com.wenyu7980.basic.common.auditing.mapper;

import com.wenyu7980.basic.common.auditing.domain.AuditingDomain;
import com.wenyu7980.basic.common.auditing.entity.AuditingEntity;

/**
 *
 * @author wenyu
 * @date 2020-02-01 
 */
public class AuditingMapper {
    private AuditingMapper() {
    }

    public static void mapTo(AuditingEntity entity, AuditingDomain domain) {
        domain.setCreatedDateTime(entity.getCreatedDateTime());
        domain.setCreatedUserId(entity.getCreatedUserId());
        domain.setDeletedFlag(entity.getDeletedFlag());
        domain.setUpdatedDateTime(entity.getUpdatedDateTime());
        domain.setUpdatedUserId(entity.getUpdatedUserId());
    }
}
