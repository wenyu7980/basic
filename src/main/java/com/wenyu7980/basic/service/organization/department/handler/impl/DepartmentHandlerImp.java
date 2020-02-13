package com.wenyu7980.basic.service.organization.department.handler.impl;

import com.wenyu7980.basic.service.organization.company.entity.CompanyEntity;
import com.wenyu7980.basic.service.organization.company.service.CompanyService;
import com.wenyu7980.basic.service.organization.department.domain.Department;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentAdd;
import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;
import com.wenyu7980.basic.service.organization.department.handler.DepartmentHandler;
import com.wenyu7980.basic.service.organization.department.mapper.DepartmentMapper;
import com.wenyu7980.basic.service.organization.department.service.DepartmentService;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
@Component
public class DepartmentHandlerImp implements DepartmentHandler {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Department addDepartment(DepartmentAdd department) {
        CompanyEntity companyEntity = companyService
                .findById(department.getCompanyId());
        DepartmentEntity parent = null;
        if (Objects.nonNull(department.getParentId())) {
            parent = departmentService.findById(department.getParentId());
        }
        DepartmentEntity entity = new DepartmentEntity(department.getName(),
                companyEntity, parent, department.getAdminIds().stream()
                .map(id -> userService.findById(id))
                .collect(Collectors.toList()));
        return DepartmentMapper.map(departmentService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void remove(String id) {
        DepartmentEntity entity = departmentService.findById(id);
        entity.setDeletedFlag(true);
        departmentService.save(entity);
    }

    @Override
    public Department modify(String id, DepartmentAdd department) {
        DepartmentEntity entity = departmentService.findById(id);
        CompanyEntity companyEntity = companyService
                .findById(department.getCompanyId());
        entity.setCompany(companyEntity);
        entity.setAdmins(department.getAdminIds().stream()
                .map(userId -> userService.findById(userId))
                .collect(Collectors.toList()));
        DepartmentEntity parent = null;
        if (Objects.nonNull(department.getParentId())) {
            parent = departmentService.findById(department.getParentId());
        }
        entity.setParent(parent);
        return DepartmentMapper.map(departmentService.save(entity));
    }
}
