package com.wenyu7980.basic.service.organization.department.handler.impl;

import com.wenyu7980.basic.service.organization.department.domain.DepartmentDetail;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentListDetail;
import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;
import com.wenyu7980.basic.service.organization.department.handler.DepartmentQueryHandler;
import com.wenyu7980.basic.service.organization.department.mapper.DepartmentMapper;
import com.wenyu7980.basic.service.organization.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 * @date 2020-03-29 
 */
@Component
public class DepartmentQueryHandlerImpl extends DepartmentQueryHandler {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public DepartmentDetail getOne(String id, boolean detailFlag) {
        DepartmentDetail detail = new DepartmentDetail();
        DepartmentMapper.map(departmentService.findById(id), detail);
        return detail;
    }

    @Override
    protected DepartmentListDetail mapList(DepartmentEntity entity,
            boolean detailFlag) {
        DepartmentListDetail departmentListDetail = new DepartmentListDetail();
        DepartmentMapper.map(entity, departmentListDetail);
        return departmentListDetail;
    }
}
