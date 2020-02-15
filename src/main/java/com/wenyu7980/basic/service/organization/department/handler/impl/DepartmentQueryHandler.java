package com.wenyu7980.basic.service.organization.department.handler.impl;

import com.wenyu7980.basic.common.query.QueryHandler;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentDetail;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentListDetail;
import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;
import com.wenyu7980.basic.service.organization.department.mapper.DepartmentMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 * @date 2020-02-14 
 */
@Component
public class DepartmentQueryHandler extends
        QueryHandler<DepartmentEntity, DepartmentListDetail, DepartmentDetail> {
    @Override
    protected DepartmentListDetail mapListDetail(DepartmentEntity entity,
            boolean detailFlag) {
        DepartmentListDetail departmentListDetail = new DepartmentListDetail();
        DepartmentMapper.map(entity, departmentListDetail);
        return departmentListDetail;
    }

    @Override
    protected DepartmentDetail mapDetail(DepartmentEntity entity,
            boolean detailFlag) {
        DepartmentDetail detail = new DepartmentDetail();
        DepartmentMapper.map(entity, detail);
        return detail;
    }
}
