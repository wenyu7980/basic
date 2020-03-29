package com.wenyu7980.basic.service.organization.company.entity;

import com.wenyu7980.basic.common.auditing.entity.AuditingEntity;
import com.wenyu7980.basic.service.organization.department.entity.DepartmentEntity;
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
public class CompanyEntity extends AuditingEntity {
    @Id
    @GenericGenerator(name = "UUID", strategy = "uuid")
    @GeneratedValue(generator = "UUID")
    private String id;
    /** 名称 */
    private String name;
    /** 公司部门 */
    @OneToMany(mappedBy = "company")
    private List<DepartmentEntity> departments;

    private CompanyEntity() {
    }

    public CompanyEntity(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
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

}
