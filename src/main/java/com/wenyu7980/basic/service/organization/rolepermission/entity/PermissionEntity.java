package com.wenyu7980.basic.service.organization.rolepermission.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @EmbeddedId
    private PermissionKey key;
    /** 权限名 */
    private String name;
    /** 角色 */
    @ManyToMany(mappedBy = "permissions")
    private List<RoleEntity> roles;

    private PermissionEntity() {
    }

    public PermissionEntity(String method, String path, String name) {
        this.key = new PermissionKey(method, path);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return this.key.getPath();
    }

    public String getMethod() {
        return this.key.getMethod();
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
        return Objects.equals(this.key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key);
    }
}
