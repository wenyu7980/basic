package com.wenyu7980.basic.service.organization.menu.repository;

import com.wenyu7980.basic.service.organization.menu.entity.OperatorEntity;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Repository
public interface OperatorRepo
        extends JpaRepository<OperatorEntity, OperatorKey> {
    /**
     * 通过用户id查询
     * @param userId
     * @return
     */
    List<OperatorEntity> findByRoleUsersId(String userId);
}
