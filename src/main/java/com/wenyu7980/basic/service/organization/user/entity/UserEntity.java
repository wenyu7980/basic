package com.wenyu7980.basic.service.organization.user.entity;

import com.wenyu7980.basic.common.auditing.entity.AuditingEntity;
import com.wenyu7980.basic.service.organization.company.entity.CompanyEntity;
import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;
import com.wenyu7980.basic.service.organization.role.entity.RoleEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * 用户表
 * @author wenyu
 * @date 2020-01-26 
 */
@Table(name = "sys_user")
@Entity
@EntityListeners({ AuditingEntityListener.class })
public class UserEntity extends AuditingEntity {
    /** 用户id */
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    @GeneratedValue(generator = "UUID")
    private String id;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;

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
    /** 管理的公司 */
    @OneToMany(mappedBy = "admin")
    private List<CompanyEntity> companies;

    private UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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

    public List<CompanyEntity> getCompanies() {
        return companies;
    }

}
