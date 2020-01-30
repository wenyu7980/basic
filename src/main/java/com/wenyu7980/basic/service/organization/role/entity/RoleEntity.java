package com.wenyu7980.basic.service.organization.role.entity;

import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import com.wenyu7980.basic.service.organization.permission.entity.PermissionEntity;
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
public class RoleEntity {
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
    }, inverseJoinColumns = { @JoinColumn(name = "permission_code") })
    private List<PermissionEntity> permissions;

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
}
