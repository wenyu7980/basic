package com.wenyu7980.basic.authorization.handler.impl;

import com.wenyu7980.basic.authorization.component.TokenComponent;
import com.wenyu7980.basic.authorization.constant.TokenType;
import com.wenyu7980.basic.authorization.domain.Login;
import com.wenyu7980.basic.authorization.domain.LoginResult;
import com.wenyu7980.basic.authorization.entity.TokenEntity;
import com.wenyu7980.basic.authorization.handler.LoginHandler;
import com.wenyu7980.basic.authorization.util.PasswordUtil;
import com.wenyu7980.basic.exception.code400.RequestBodyBadException;
import com.wenyu7980.basic.exception.code401.LoginFailException;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
@Component
public class LoginHandlerImpl implements LoginHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenComponent tokenComponent;
    /** 单次登录 */
    @Value("${application.login.single:false}")
    private Boolean single;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public LoginResult login(Login login) {
        LoginResult result = new LoginResult();
        UserEntity entity = userService.findByUsername(login.getUsername());
        if (entity.getDeletedFlag()) {
            throw new RequestBodyBadException("用户:{0}已禁用", login.getUsername());
        }
        if (!Objects.equals(entity.getPassword(),
                PasswordUtil.encode(login.getPassword()))) {
            throw new LoginFailException("密码不正确");
        }
        if (single) {
            // 失效旧token
            tokenComponent.invalidToken(entity.getId());
        }
        // 获取旧token信息
        Optional<TokenEntity> old = tokenComponent
                .getLastestToken(entity.getId());
        // 获取新的token
        Map<TokenType, String> tokens = tokenComponent
                .getTokens(entity.getId(), entity.getDepartment().getId(),
                        entity.getSystem(), entity.getUsername());
        result.setUser(UserMapper.simpleMap(entity));
        result.setHeaderToken(tokens.get(TokenType.HEADER));
        result.setQueryToken(tokens.get(TokenType.QUERY));
        result.setSystem(entity.getSystem());
        return result;
    }
}
