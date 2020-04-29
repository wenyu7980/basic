package com.wenyu7980.basic.service.organization.rolepermission.handler.impl;

import com.wenyu7980.basic.service.organization.rolepermission.domain.RoleDetail;
import com.wenyu7980.basic.service.organization.rolepermission.domain.RoleListDetail;
import com.wenyu7980.basic.service.organization.rolepermission.entity.RoleEntity;
import com.wenyu7980.basic.service.organization.rolepermission.handler.RoleQueryHandler;
import com.wenyu7980.basic.service.organization.rolepermission.mapper.PermissionMapper;
import com.wenyu7980.basic.service.organization.rolepermission.mapper.RoleMapper;
import com.wenyu7980.basic.service.organization.rolepermission.service.RoleService;
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
            detail.setOperatorCodes(entity.getOperators());
            detail.setMenuCodes(entity.getMenus());
            detail.setPermissions(
                    entity.getPermissions().stream().map(PermissionMapper::map)
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
