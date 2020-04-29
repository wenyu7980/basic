package com.wenyu7980.basic.service.organization.user.service.impl;

import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.organization.user.entity.DepartmentEntity;
import com.wenyu7980.basic.service.organization.user.repository.DepartmentRepo;
import com.wenyu7980.basic.service.organization.user.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentEntity findById(String id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("部门{0}不存在", id));
    }

    @Override
    public DepartmentEntity save(DepartmentEntity entity) {
        return departmentRepo.save(entity);
    }
}
