package com.wenyu7980.basic.service.organization.company.entity;

import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;
import com.wenyu7980.basic.service.organization.user.entity.UserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 公司
 * @author wenyu
 * @date 2020-01-26 
 */
@Table(name = "sys_company")
@Entity
public class CompanyEntity {
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;
    /** 名称 */
    private String name;
    /** 公司部门 */
    @OneToMany(mappedBy = "company")
    private List<DepartmentEntity> departments;
    /** 公司管理员 */
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private UserEntity admin;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<DepartmentEntity> getDepartments() {
        return departments;
    }

    public UserEntity getAdmin() {
        return admin;
    }
}
