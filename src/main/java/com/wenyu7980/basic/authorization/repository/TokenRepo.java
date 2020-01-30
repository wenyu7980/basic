package com.wenyu7980.basic.authorization.repository;

import com.wenyu7980.basic.authorization.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Repository
public interface TokenRepo extends JpaRepository<TokenEntity, String> {
    /**
     * 通过用户id查询
     * @param userId
     * @param valid
     * @return
     */
    List<TokenEntity> findByUserIdAndValid(String userId, Boolean valid);

    /**
     * 查询最新一条
     * @param userId
     * @return
     */
    @Query(nativeQuery = true, value = "select * from sys_token where user_id = ? order by login_date_time desc limit 1")
    Optional<TokenEntity> findLatestByUserId(String userId);
}
