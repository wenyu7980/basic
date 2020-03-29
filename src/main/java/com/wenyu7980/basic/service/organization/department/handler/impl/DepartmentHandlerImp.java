package com.wenyu7980.basic.service.organization.department.handler.impl;

import com.wenyu7980.basic.exception.code409.InconsistentException;
import com.wenyu7980.basic.service.organization.company.entity.CompanyEntity;
import com.wenyu7980.basic.service.organization.company.service.CompanyService;
import com.wenyu7980.basic.service.organization.department.domain.Department;
import com.wenyu7980.basic.service.organization.department.domain.DepartmentAdd;
import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;
import com.wenyu7980.basic.service.organization.department.handler.DepartmentHandler;
import com.wenyu7980.basic.service.organization.department.handler.DepartmentUserHandler;
import com.wenyu7980.basic.service.organization.department.mapper.DepartmentMapper;
import com.wenyu7980.basic.service.organization.department.service.DepartmentService;
import com.wenyu7980.basic.service.organization.user.domain.User;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
@Component
public class DepartmentHandlerImp
        implements DepartmentHandler, DepartmentUserHandler {
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
                companyEntity, parent);
        return DepartmentMapper.map(departmentService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void remove(String id) {
        DepartmentEntity entity = departmentService.findById(id);
        if (entity.getDeletedFlag()) {
            throw new InconsistentException("部门:{0}已删除，请勿重复删除",
                    entity.getName());
        }
        entity.setDeletedFlag(true);
        departmentService.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Department modify(String id, DepartmentAdd department) {
        DepartmentEntity entity = departmentService.findById(id);
        CompanyEntity companyEntity = companyService
                .findById(department.getCompanyId());
        entity.setCompany(companyEntity);
        DepartmentEntity parent = null;
        if (Objects.nonNull(department.getParentId())) {
            parent = departmentService.findById(department.getParentId());
        }
        entity.setParent(parent);
        return DepartmentMapper.map(departmentService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Department modifyUser(String id, Set<String> userIds) {
        DepartmentEntity entity = departmentService.findById(id);
        entity.setUsers(
                userIds.stream().map(userId -> userService.findById(userId))
                        .collect(Collectors.toList()));
        return DepartmentMapper.map(departmentService.save(entity));
    }

    @Override
    public List<User> getUserByDepartment(String id) {
        return departmentService.findById(id).getUsers().stream()
                .map(UserMapper::map).collect(Collectors.toList());
    }

    @Override
    public List<User> getAdminByDepartment(String id) {
        return departmentService.findById(id).getAdmins().stream()
                .map(UserMapper::map).collect(Collectors.toList());
    }

    @Override
    public Department modifyAdmin(String id, Set<String> userIds) {
        DepartmentEntity entity = departmentService.findById(id);
        entity.setAdmins(
                userIds.stream().map(userId -> userService.findById(userId))
                        .collect(Collectors.toList()));
        return DepartmentMapper.map(departmentService.save(entity));
    }
}
