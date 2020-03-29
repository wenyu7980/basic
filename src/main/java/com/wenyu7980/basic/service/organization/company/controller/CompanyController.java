package com.wenyu7980.basic.service.organization.company.controller;

import com.wenyu7980.basic.service.organization.company.domain.Company;
import com.wenyu7980.basic.service.organization.company.domain.CompanyAdd;
import com.wenyu7980.basic.service.organization.company.handler.CompanyHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author wenyu
 * @date 2020-02-13 
 */
@Api(tags = "公司管理")
@RestController
@RequestMapping("companys")
public class CompanyController {
    @Autowired
    private CompanyHandler companyHandler;

    @ApiOperation("创建公司")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company add(@RequestBody @Valid CompanyAdd company) {
        return companyHandler.add(company);
    }

    @ApiOperation("修改公司")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Company modify(@ApiParam("公司id") @PathVariable("id") String id,
            @RequestBody @Valid CompanyAdd company) {
        return companyHandler.modify(id, company);
    }

    @ApiOperation("删除公司")
    @DeleteMapping("id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@ApiParam("公司id") @PathVariable("id") String id) {
        companyHandler.delete(id);
    }
}
