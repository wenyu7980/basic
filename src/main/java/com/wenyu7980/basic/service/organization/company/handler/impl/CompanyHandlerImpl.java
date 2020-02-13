package com.wenyu7980.basic.service.organization.company.handler.impl;

import com.wenyu7980.basic.exception.code409.InconsistentException;
import com.wenyu7980.basic.service.organization.company.domain.Company;
import com.wenyu7980.basic.service.organization.company.domain.CompanyAdd;
import com.wenyu7980.basic.service.organization.company.entity.CompanyEntity;
import com.wenyu7980.basic.service.organization.company.handler.CompanyHandler;
import com.wenyu7980.basic.service.organization.company.mapper.CompanyMapper;
import com.wenyu7980.basic.service.organization.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
@Component
public class CompanyHandlerImpl implements CompanyHandler {
    @Autowired
    private CompanyService companyService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Company add(CompanyAdd company) {
        CompanyEntity entity = new CompanyEntity(company.getName());
        return CompanyMapper.map(companyService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public Company modify(String id, CompanyAdd company) {
        CompanyEntity entity = companyService.findById(id);
        entity.setName(company.getName());
        return CompanyMapper.map(companyService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
    public void delete(String id) {
        CompanyEntity entity = companyService.findById(id);
        if (entity.getDeletedFlag()) {
            throw new InconsistentException("公司:{0}已删除，请勿重复删除",
                    entity.getName());
        }
        entity.setDeletedFlag(true);
        companyService.save(entity);
    }
}
