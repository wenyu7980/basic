package com.wenyu7980.basic.service.organization.user.mapper;

import com.wenyu7980.basic.common.auditing.mapper.AuditingMapper;
import com.wenyu7980.basic.service.organization.user.domain.Department;
import com.wenyu7980.basic.service.organization.user.domain.DepartmentSimple;
import com.wenyu7980.basic.service.organization.user.entity.DepartmentEntity;

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
        return simple;
    }
}
