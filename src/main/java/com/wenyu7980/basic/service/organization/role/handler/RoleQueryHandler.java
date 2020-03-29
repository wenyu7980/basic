package com.wenyu7980.basic.service.organization.role.handler;

import com.wenyu7980.basic.common.query.QueryHandler;
import com.wenyu7980.basic.service.organization.role.domain.RoleDetail;
import com.wenyu7980.basic.service.organization.role.domain.RoleListDetail;
import com.wenyu7980.basic.service.organization.role.entity.RoleEntity;

/**
 *
 * @author wenyu
 * @date 2020-03-29 
 */
public abstract class RoleQueryHandler
        extends QueryHandler<RoleEntity, RoleListDetail> {
    /**
     * 查询
     * @param id
     * @param detailFlag
     * @return
     */
    public abstract RoleDetail getOne(String id, boolean detailFlag);
}
