package com.wenyu7980.basic.service.organization.menu.service;

import com.wenyu7980.basic.common.service.CommonService;
import com.wenyu7980.basic.service.organization.menu.entity.MenuEntity;
import com.wenyu7980.basic.service.organization.menu.entity.MenuKey;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
public interface MenuService extends CommonService<MenuEntity, MenuKey> {
    /**
     * 保存
     * @param entities
     * @return
     */
    List<MenuEntity> saveAll(List<MenuEntity> entities);

    /**
     * 通过用户id查询
     * @param userId
     * @return
     */
    List<MenuEntity> findByUserId(String userId);
}
