package com.wenyu7980.basic.authorization.handler.impl;

import com.wenyu7980.basic.authorization.entity.TokenEntity;
import com.wenyu7980.basic.authorization.handler.LogoutHandler;
import com.wenyu7980.basic.authorization.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wenyu
 * @date 2020-02-11 
 */
@Component
public class LogoutHandlerImpl implements LogoutHandler {
    @Autowired
    private TokenService tokenService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void logout(String token) {
        TokenEntity entity = tokenService.findById(token);
        entity.invalid();
        tokenService.save(entity);
    }
}
