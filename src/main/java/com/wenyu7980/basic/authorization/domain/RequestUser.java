package com.wenyu7980.basic.authorization.domain;

import com.wenyu7980.basic.authorization.constant.TokenType;

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
    /** 公司id */
    private String companyId;
    /** 用户名 */
    private String username;
    /** token */
    private String token;
    /** token类型 */
    private TokenType tokenType;

    public RequestUser(String userId, String departmentId, String companyId,
            String username, String token, TokenType tokenType) {
        this.userId = userId;
        this.departmentId = departmentId;
        this.companyId = companyId;
        this.username = username;
        this.token = token;
        this.tokenType = tokenType;
    }

    public String getUserId() {
        return userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getCompanyId() {
        return companyId;
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
}
