package com.wenyu7980.basic.service.organization.permission.entity;

import com.wenyu7980.basic.service.organization.role.entity.RoleEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

/**
 * 权限
 * @author wenyu
 * @date 2020-01-26 
 */
@Table(name = "sys_permission")
@Entity
public class PermissionEntity {
    /** 权限code */
    @Id
    private String code;
    /** 权限名 */
    private String name;
    /** 请求方法:POST,GET,HEAD,DELETE,PUT */
    private String method;
    /** 路径 */
    private String path;
    /** 角色 */
    @ManyToMany(mappedBy = "permissions")
    private List<RoleEntity> roles;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        PermissionEntity that = (PermissionEntity) object;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
