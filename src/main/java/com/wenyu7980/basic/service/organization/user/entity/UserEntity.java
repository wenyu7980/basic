package com.wenyu7980.basic.service.organization.user.entity;

import com.wenyu7980.basic.common.auditing.entity.AuditingEntity;
import com.wenyu7980.basic.service.organization.rolepermission.entity.RoleEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 用户表
 * @author wenyu
 * @date 2020-01-26 
 */
@Table(name = "sys_user")
@Entity
public class UserEntity extends AuditingEntity {
    /** 用户id */
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    @GeneratedValue(generator = "UUID")
    private String id;
    /** 用户名 */
    private String username;
    /** 用户名称 */
    private String name;
    /** 密码 */
    private String password;
    /** 系统管理员 */
    private Boolean system = false;

    /** 角色 */
    @ManyToMany
    @JoinTable(name = "sys_user_role", joinColumns = {
            @JoinColumn(name = "user_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "role_id")
    })
    private List<RoleEntity> roles;
    /** 用户所在部门 */
    @ManyToMany(mappedBy = "users")
    private List<DepartmentEntity> departments;
    /** 管理的部门 */
    @ManyToMany(mappedBy = "admins")
    private List<DepartmentEntity> adminDepartments;

    private UserEntity() {
    }

    public UserEntity(String username, String name, String password) {
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getSystem() {
        return system;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public List<DepartmentEntity> getDepartments() {
        return departments;
    }

    public List<DepartmentEntity> getAdminDepartments() {
        return adminDepartments;
    }

}
