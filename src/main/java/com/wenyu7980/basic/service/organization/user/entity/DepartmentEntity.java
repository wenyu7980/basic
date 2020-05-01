package com.wenyu7980.basic.service.organization.user.entity;

import com.wenyu7980.basic.common.auditing.entity.AuditingEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * 部门
 * @author wenyu
 * @date 2020-01-26 
 */
@Table(name = "sys_department")
@Entity
public class DepartmentEntity extends AuditingEntity {
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    @GeneratedValue(generator = "UUID")
    private String id;
    /** 部门名称 */
    private String name;
    /** 子部门 */
    @OneToMany(mappedBy = "parent")
    private List<DepartmentEntity> departments;
    /** 上级部门 */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private DepartmentEntity parent;
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private UserEntity admin;
    /** 部门员工 */
    @OneToMany(mappedBy = "department")
    private List<UserEntity> users;

    private DepartmentEntity() {
    }

    public DepartmentEntity(String name, DepartmentEntity department) {
        this.name = name;
        this.parent = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public void setParent(DepartmentEntity parent) {
        this.parent = parent;
    }

    public UserEntity getAdmin() {
        return admin;
    }

    public void setAdmin(UserEntity admin) {
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<DepartmentEntity> getDepartments() {
        return departments;
    }

    public DepartmentEntity getParent() {
        return parent;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        DepartmentEntity that = (DepartmentEntity) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
