package com.wenyu7980.basic.service.organization.rolepermission.entity;

import com.wenyu7980.basic.common.auditing.entity.AuditingEntity;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * 角色
 * @author wenyu
 * @date 2020-01-26 
 */
@Table(name = "sys_role")
@Entity
public class RoleEntity extends AuditingEntity {
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    @GeneratedValue(generator = "UUID")
    private String id;
    /** 角色名 */
    private String name;
    /** 拥有角色的用户 */
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;
    /** 角色分配的权限 */
    @ManyToMany
    @JoinTable(name = "sys_role_permission", joinColumns = {
            @JoinColumn(name = "role_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "method", referencedColumnName = "method"),
            @JoinColumn(name = "path", referencedColumnName = "path")
    })
    private List<PermissionEntity> permissions;
    /** 菜单 */
    @Column(columnDefinition = "json")
    private Set<String> menus;
    /** 操作 */
    @Column(columnDefinition = "json")
    private Set<String> operators;

    public void setName(String name) {
        this.name = name;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public Set<String> getMenus() {
        return menus;
    }

    public void setMenus(Set<String> menus) {
        this.menus = menus;
    }

    public Set<String> getOperators() {
        return operators;
    }

    public void setOperators(Set<String> operators) {
        this.operators = operators;
    }
}
