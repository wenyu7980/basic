package com.wenyu7980.basic.service.organization.role.entity;

import com.wenyu7980.basic.common.auditing.entity.AuditingEntity;
import com.wenyu7980.basic.service.organization.menu.entity.MenuEntity;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorEntity;
import com.wenyu7980.basic.service.organization.permission.entity.PermissionEntity;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 角色
 * @author wenyu
 * @date 2020-01-26 
 */
@Table(name = "sys_role")
@Entity
public class RoleEntity extends AuditingEntity {
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid")
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
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<MenuEntity> menus;
    /** 操作 */
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<OperatorEntity> operators;

    public void setName(String name) {
        this.name = name;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }

    public void setOperators(List<OperatorEntity> operators) {
        this.operators = operators;
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

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public List<OperatorEntity> getOperators() {
        return operators;
    }
}
