package com.wenyu7980.basic.authorization.service;

import com.wenyu7980.basic.authorization.entity.TokenEntity;
import com.wenyu7980.basic.common.service.CommonService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
public interface TokenService extends CommonService<TokenEntity, String> {
    /**
     * 查询
     * @param id
     * @return
     */
    Optional<TokenEntity> findOptionalById(String id);

    /**
     * 通过用户id查询
     * @param userId
     * @return
     */
    List<TokenEntity> findByUserIdAndValid(String userId);

    /**
     * 获取最新的token
     * @param userId
     * @return
     */
    Optional<TokenEntity> findLatestByUserId(String userId);
}
