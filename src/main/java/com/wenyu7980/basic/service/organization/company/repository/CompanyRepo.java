package com.wenyu7980.basic.service.organization.company.repository;

import com.wenyu7980.basic.service.organization.company.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wenyu
 * @date 2020-01-26 
 */
@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, String> {
}
