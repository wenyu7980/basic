package com.wenyu7980.basic.service.organization.rolepermission.repository;

import com.wenyu7980.basic.service.organization.rolepermission.entity.PermissionEntity;
import com.wenyu7980.basic.service.organization.rolepermission.entity.PermissionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Repository
public interface PermissionRepo
        extends JpaRepository<PermissionEntity, PermissionKey>,
        JpaSpecificationExecutor<PermissionEntity> {
    /**
     * 通过method查询
     * @param method
     * @return
     */
    List<PermissionEntity> findByKeyMethod(String method);

    /**
     * 通过用户id查询
     * @param userId
     * @return
     */
    Set<PermissionEntity> findByRolesUsersId(String userId);
}
