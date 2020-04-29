package com.wenyu7980.basic.service.organization.user.repository;

import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Repository
public interface UserRepo extends JpaRepository<UserEntity, String>,
        JpaSpecificationExecutor<UserEntity> {
    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    Optional<UserEntity> findByUsername(String username);

    /**
     * 判断用户名是否已存在
     * @param username
     * @return
     */
    boolean existsByUsername(String username);
}
