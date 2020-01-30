package com.wenyu7980.basic.service.organization.company.service.impl;

import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.organization.company.entity.CompanyEntity;
import com.wenyu7980.basic.service.organization.company.repository.CompanyRepo;
import com.wenyu7980.basic.service.organization.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public CompanyEntity findById(String id) {
        return companyRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("公司{0}不存在", id));
    }

    @Override
    public CompanyEntity save(CompanyEntity entity) {
        return companyRepo.save(entity);
    }
}
