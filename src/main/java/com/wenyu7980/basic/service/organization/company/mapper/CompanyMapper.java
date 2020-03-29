package com.wenyu7980.basic.service.organization.company.mapper;

import com.wenyu7980.basic.common.auditing.mapper.AuditingMapper;
import com.wenyu7980.basic.service.organization.company.domain.Company;
import com.wenyu7980.basic.service.organization.company.entity.CompanyEntity;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
public class CompanyMapper {
    private CompanyMapper() {
    }

    public static Company map(CompanyEntity entity) {
        Company company = new Company();
        map(entity, company);
        return company;
    }

    public static void map(CompanyEntity entity, Company company) {
        company.setId(entity.getId());
        company.setName(entity.getName());
        AuditingMapper.mapTo(entity, company);
    }
}
