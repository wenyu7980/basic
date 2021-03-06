package com.wenyu7980.basic.service.organization.rolepermission.repository;

import com.wenyu7980.basic.service.organization.rolepermission.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, String>,
        JpaSpecificationExecutor<RoleEntity> {
    /**
     * 用户查询
     * @param id
     * @return
     */
    List<RoleEntity> findByUsersId(String id);
}
