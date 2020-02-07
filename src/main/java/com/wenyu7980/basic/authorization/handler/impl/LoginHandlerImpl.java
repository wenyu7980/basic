package com.wenyu7980.basic.authorization.handler.impl;

import com.wenyu7980.basic.authorization.component.TokenComponent;
import com.wenyu7980.basic.authorization.constant.TokenType;
import com.wenyu7980.basic.authorization.domain.Login;
import com.wenyu7980.basic.authorization.domain.LoginResult;
import com.wenyu7980.basic.authorization.entity.TokenEntity;
import com.wenyu7980.basic.authorization.handler.LoginHandler;
import com.wenyu7980.basic.authorization.util.PasswordUtil;
import com.wenyu7980.basic.exception.code401.LoginFailException;
import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;
import com.wenyu7980.basic.service.organization.menu.entity.MenuEntity;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorEntity;
import com.wenyu7980.basic.service.organization.menu.service.MenuService;
import com.wenyu7980.basic.service.organization.menu.service.OperatorService;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.user.mapper.UserMapper;
import com.wenyu7980.basic.service.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    private MenuService menuService;
    @Autowired
    private OperatorService operatorService;
    /** 单次登录 */
    @Value("${application.login.single:false}")
    private Boolean single;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)

    public LoginResult login(Login login) {
        LoginResult result = new LoginResult();
        UserEntity entity = userService.findByUsername(login.getUsername());
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
        String departmentId = null;
        if (old.isPresent()) {
            // 旧token中的departmentId
            departmentId = old.get().getDepartmentId();
            result.setLatestLoginDateTime(old.get().getLoginDateTime());
        }
        final Set<DepartmentEntity> departments = new LinkedHashSet<>();
        departments.addAll(entity.getDepartments());
        departments.addAll(entity.getAdminDepartments());
        if (departments.size() == 0) {
            departmentId = null;
        }
        // 确认departmentId
        DepartmentEntity departmentEntity = null;
        for (DepartmentEntity department : departments) {
            departmentEntity = department;
            departmentId = department.getId();
            if (Objects.equals(department.getId(), departmentId)) {
                break;
            }
        }
        // 获取新的token
        Map<TokenType, String> tokens = tokenComponent
                .getTokens(entity.getId(), departmentId,
                        departmentEntity != null ?
                                departmentEntity.getCompany().getId() :
                                null, entity.getUsername());
        result.setUser(UserMapper.simpleMap(entity));
        result.setHeaderToken(tokens.get(TokenType.HEADER));
        result.setQueryToken(tokens.get(TokenType.QUERY));
        result.setMenus(menuService.findByUserId(entity.getId()).stream()
                .map(MenuEntity::getCode).collect(Collectors.toSet()));
        result.setOperators(
                operatorService.findByUserId(entity.getId()).stream()
                        .map(OperatorEntity::getCode)
                        .collect(Collectors.toSet()));
        return result;
    }
}
