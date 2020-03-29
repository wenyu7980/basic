package com.wenyu7980.basic.service.organization.company.handler;

import com.wenyu7980.basic.service.organization.company.domain.Company;
import com.wenyu7980.basic.service.organization.company.domain.CompanyAdd;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
public interface CompanyHandler {
    /**
     * 创建公司
     * @param company
     * @return
     */
    Company add(CompanyAdd company);

    /**
     * 修改
     * @param id
     * @param company
     * @return
     */
    Company modify(String id, CompanyAdd company);

    /**
     * 删除
     * @param id
     */
    void delete(String id);
}
