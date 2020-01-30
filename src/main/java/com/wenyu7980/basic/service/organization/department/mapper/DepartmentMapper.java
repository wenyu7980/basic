package com.wenyu7980.basic.service.organization.department.mapper;

import com.wenyu7980.basic.service.organization.department.domain.DepartmentSimple;
import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;

/**
 *
 * @author wenyu
 * @date 2020-01-29 
 */
public class DepartmentMapper {
    private DepartmentMapper() {
    }

    public static DepartmentSimple simpleMap(DepartmentEntity entity) {
        DepartmentSimple simple = new DepartmentSimple();
        simple.setId(entity.getId());
        simple.setName(entity.getName());
        simple.setCompanyId(entity.getCompany().getId());
        simple.setCompanyName(entity.getCompany().getName());
        return simple;
    }
}
