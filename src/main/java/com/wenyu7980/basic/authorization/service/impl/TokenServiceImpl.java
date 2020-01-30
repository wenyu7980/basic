package com.wenyu7980.basic.authorization.service.impl;

import com.wenyu7980.basic.authorization.entity.TokenEntity;
import com.wenyu7980.basic.authorization.repository.TokenRepo;
import com.wenyu7980.basic.authorization.service.TokenService;
import com.wenyu7980.basic.exception.code404.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepo tokenRepo;

    @Override
    public TokenEntity findById(String id) {
        return tokenRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("token不存在"));
    }

    @Override
    public TokenEntity save(TokenEntity entity) {
        return tokenRepo.save(entity);
    }

    @Override
    public Optional<TokenEntity> findOptionalById(String id) {
        return tokenRepo.findById(id);
    }

    @Override
    public List<TokenEntity> findByUserIdAndValid(String userId) {
        return tokenRepo.findByUserIdAndValid(userId, true);
    }

    @Override
    public Optional<TokenEntity> findLatestByUserId(String userId) {
        return tokenRepo.findLatestByUserId(userId);
    }
}
