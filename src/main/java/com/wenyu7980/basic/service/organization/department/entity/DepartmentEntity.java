package com.wenyu7980.basic.service.organization.department.entity;

import com.wenyu7980.basic.service.organization.company.entity.CompanyEntity;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 部门
 * @author wenyu
 * @date 2020-01-26 
 */
@Table(name = "sys_department")
@Entity
public class DepartmentEntity {
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid")
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
    /** 所属公司 */
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
    @ManyToMany
    @JoinTable(name = "sys_department_admin", joinColumns = {
            @JoinColumn(name = "department_id")
    }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private List<UserEntity> admins;

    /** 部门员工 */
    @ManyToMany
    @JoinTable(name = "sys_department_user", joinColumns = {
            @JoinColumn(name = "department_id")
    }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private List<UserEntity> users;

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

    public CompanyEntity getCompany() {
        return company;
    }

    public Optional<String> getCompanyId() {
        return getCompany() == null ?
                Optional.empty() :
                Optional.of(getCompany().getId());
    }

    public List<UserEntity> getAdmins() {
        return admins;
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
