package com.wenyu7980.basic.authorization.entity;

import com.wenyu7980.basic.authorization.constant.TokenType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Table(name = "sys_token")
@Entity
public class TokenEntity {
    /** token */
    @Id
    private String token;
    /** token类型 */
    @Enumerated(EnumType.STRING)
    private TokenType type;
    /** 用户id */
    private String userId;
    /** 用户名 */
    private String username;
    /** 部门id */
    private String departmentId;
    /** 公司id */
    private String companyId;
    /** 系统管理员 */
    private Boolean system;
    /** 过期时间（s） */
    private Long expire;
    /** 是否有效 */
    private Boolean valid = true;
    /** 失效时间 */
    private LocalDateTime invalidDateTime;
    /** 登录时间 */
    private LocalDateTime loginDateTime;

    /**
     * header token
     * @param userId
     * @param departmentId
     * @param companyId
     * @param system
     * @param username
     * @param expire
     * @return
     */
    public static TokenEntity ofHeader(String userId, String departmentId,
            String companyId, Boolean system, String username, Long expire) {
        return new TokenEntity(TokenType.HEADER, userId, departmentId,
                companyId, system, username, expire);
    }

    /**
     * query token
     * @param userId
     * @param departmentId
     * @param companyId
     * @param system
     * @param username
     * @param expire
     * @return
     */
    public static TokenEntity ofQuery(String userId, String departmentId,
            String companyId, Boolean system, String username, Long expire) {
        return new TokenEntity(TokenType.QUERY, userId, departmentId, companyId,
                system, username, expire);
    }

    private TokenEntity() {
    }

    private TokenEntity(TokenType type, String userId, String departmentId,
            String companyId, Boolean system, String username, Long expire) {
        this.token = UUID.randomUUID().toString().replaceAll("-", "");
        this.type = type;
        this.userId = userId;
        this.departmentId = departmentId;
        this.companyId = companyId;
        this.username = username;
        this.expire = expire;
        this.loginDateTime = LocalDateTime.now();
        this.system = system;
    }

    /**
     * 检查并更新有效性
     * @return
     */
    public boolean checkAndUpdateValid() {
        final long epochSecond = this.loginDateTime
                .toEpochSecond(ZoneOffset.of("+8"));
        final long currentSecond = LocalDateTime.now()
                .toEpochSecond(ZoneOffset.of("+8"));
        if ((epochSecond + this.expire) < currentSecond) {
            this.invalid();
        }
        return this.valid;
    }

    public void invalid() {
        this.invalidDateTime = LocalDateTime.now();
        this.valid = false;
    }

    public String getToken() {
        return token;
    }

    public TokenType getType() {
        return type;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getInvalidDateTime() {
        return invalidDateTime;
    }

    public LocalDateTime getLoginDateTime() {
        return loginDateTime;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Boolean getSystem() {
        return system;
    }
}
