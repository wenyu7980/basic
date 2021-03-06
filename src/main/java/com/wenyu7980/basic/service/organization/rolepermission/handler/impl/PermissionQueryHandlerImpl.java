package com.wenyu7980.basic.service.organization.rolepermission.handler.impl;

import com.wenyu7980.basic.common.query.QueryService;
import com.wenyu7980.basic.service.organization.rolepermission.domain.Permission;
import com.wenyu7980.basic.service.organization.rolepermission.entity.PermissionEntity;
import com.wenyu7980.basic.service.organization.rolepermission.handler.PermissionQueryHandler;
import com.wenyu7980.basic.service.organization.rolepermission.mapper.PermissionMapper;
import com.wenyu7980.query.QueryLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Component
public class PermissionQueryHandlerImpl implements PermissionQueryHandler {
    @Autowired
    private QueryService<PermissionEntity> queryService;

    @Override
    public List<Permission> getPermissions() {
        return queryService.findAll(QueryLogic.and()).stream()
                .map(PermissionMapper::map).collect(Collectors.toList());
    }
}
