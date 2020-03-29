package com.wenyu7980.basic.service.organization.department.handler;

import com.wenyu7980.basic.common.query.QueryHandler;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentDetail;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentListDetail;
import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;

/**
 *
 * @author wenyu
 * @date 2020-03-29 
 */
public abstract class DepartmentQueryHandler
        extends QueryHandler<DepartmentEntity, DepartmentListDetail> {
    /**
     * 查询
     * @param id
     * @param detailFlag
     * @return
     */
    public abstract DepartmentDetail getOne(String id, boolean detailFlag);
}
