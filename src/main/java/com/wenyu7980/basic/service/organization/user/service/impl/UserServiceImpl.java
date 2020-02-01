package com.wenyu7980.basic.service.organization.user.service.impl;

import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.repositry.UserRepo;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity findById(String id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("用户{0}不存在", id));
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepo.save(entity);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("用户{0}不存在", username));
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }
}
