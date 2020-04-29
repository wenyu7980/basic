package com.wenyu7980.basic.authorization.domain;

import com.wenyu7980.basic.authorization.constant.TokenType;
import com.wenyu7980.basic.authorization.entity.TokenEntity;

/**
 *
 * @author wenyu
 * @date 2020-01-29 
 */
public class RequestUser {
    /** 用户id */
    private String userId;
    /** 部门id */
    private String departmentId;
    /** 系统管理员 */
    private Boolean system;
    /** 用户名 */
    private String username;
    /** token */
    private String token;
    /** token类型 */
    private TokenType tokenType;

    public RequestUser(TokenEntity entity) {
        this.userId = entity.getUserId();
        this.departmentId = entity.getDepartmentId();
        this.system = entity.getSystem();
        this.token = entity.getToken();
        this.tokenType = entity.getType();
        this.username = entity.getUsername();
    }

    public String getUserId() {
        return userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public Boolean getSystem() {
        return system;
    }
}
