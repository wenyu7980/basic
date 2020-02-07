package com.wenyu7980.basic.service.organization.menu.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Embeddable
public class OperatorKey implements Serializable {
    /** 角色id */
    private String roleId;
    private String code;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        OperatorKey menuKey = (OperatorKey) object;
        return Objects.equals(roleId, menuKey.roleId) && Objects
                .equals(code, menuKey.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, code);
    }
}
