package com.wenyu7980.basic.service.organization.role.handler.impl;

import com.wenyu7980.basic.common.query.QueryHandler;
import com.wenyu7980.basic.service.organization.menu.entity.MenuEntity;
import com.wenyu7980.basic.service.organization.menu.entity.OperatorEntity;
import com.wenyu7980.basic.service.organization.role.domain.RoleDetail;
import com.wenyu7980.basic.service.organization.role.domain.RoleListDetail;
import com.wenyu7980.basic.service.organization.role.entity.RoleEntity;
import com.wenyu7980.basic.service.organization.role.mapper.RoleMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 *
 * @author wenyu
 * @date 2020-02-10 
 */
@Component
public class RoleQueryHandler
        extends QueryHandler<RoleEntity, RoleListDetail, RoleDetail> {

    private void mapListDetail(RoleEntity entity, RoleListDetail detail) {
        RoleMapper.map(entity, detail);
    }

    @Override
    protected RoleListDetail mapListDetail(RoleEntity entity,
            boolean detailFlag) {
        RoleListDetail detail = new RoleListDetail();
        RoleMapper.map(entity, detail);
        if (detailFlag) {
            this.mapListDetail(entity, detail);
        }
        return detail;
    }

    @Override
    protected RoleDetail mapDetail(RoleEntity entity, boolean detailFlag) {
        RoleDetail detail = new RoleDetail();
        RoleMapper.map(entity, detail);
        if (detailFlag) {
            this.mapListDetail(entity, detail);
            detail.setOperatorCodes(
                    entity.getOperators().stream().map(OperatorEntity::getCode)
                            .collect(Collectors.toSet()));
            detail.setMenuCodes(
                    entity.getMenus().stream().map(MenuEntity::getCode)
                            .collect(Collectors.toSet()));
        }
        return detail;
    }
}
