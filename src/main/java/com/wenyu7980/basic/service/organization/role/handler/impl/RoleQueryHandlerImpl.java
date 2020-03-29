package com.wenyu7980.basic.service.organization.role.handler.impl;

import com.wenyu7980.basic.service.organization.menu.entity.MenuEntity;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorEntity;
import com.wenyu7980.basic.service.organization.role.domain.RoleDetail;
import com.wenyu7980.basic.service.organization.role.domain.RoleListDetail;
import com.wenyu7980.basic.service.organization.role.entity.RoleEntity;
import com.wenyu7980.basic.service.organization.role.handler.RoleQueryHandler;
import com.wenyu7980.basic.service.organization.role.mapper.RoleMapper;
import com.wenyu7980.basic.service.organization.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 * @date 2020-03-29 
 */
@Component
public class RoleQueryHandlerImpl extends RoleQueryHandler {
    @Autowired
    private RoleService roleService;

    @Override
    public RoleDetail getOne(String id, boolean detailFlag) {
        RoleEntity entity = roleService.findById(id);
        RoleDetail detail = new RoleDetail();
        RoleMapper.map(entity, detail);
        if (detailFlag) {
            detail.setOperatorCodes(
                    entity.getOperators().stream().map(OperatorEntity::getCode)
                            .collect(Collectors.toSet()));
            detail.setMenuCodes(
                    entity.getMenus().stream().map(MenuEntity::getCode)
                            .collect(Collectors.toSet()));
        }
        return detail;
    }

    @Override
    protected RoleListDetail mapList(RoleEntity entity, boolean detailFlag) {
        RoleListDetail detail = new RoleListDetail();
        RoleMapper.map(entity, detail);
        return detail;
    }
}
