package com.wenyu7980.basic.service.organization.department.mapper;

import com.wenyu7980.basic.common.auditing.mapper.AuditingMapper;
import com.wenyu7980.basic.service.organization.department.domain.Department;
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

    public static Department map(DepartmentEntity entity) {
        Department department = new Department();
        map(entity, department);
        return department;
    }

    public static void map(DepartmentEntity entity, Department department) {
        department.setId(entity.getId());
        department.setName(entity.getName());
        AuditingMapper.mapTo(entity, department);
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
