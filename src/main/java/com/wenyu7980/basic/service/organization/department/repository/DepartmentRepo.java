package com.wenyu7980.basic.service.organization.department.repository;

import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, String>,
        JpaSpecificationExecutor<DepartmentEntity> {
}
