package com.wenyu7980.basic.service.organization.user.repositry;

import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {
    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    Optional<UserEntity> findByUsername(String username);
}