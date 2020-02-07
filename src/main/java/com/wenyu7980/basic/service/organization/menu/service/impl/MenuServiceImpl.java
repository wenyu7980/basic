package com.wenyu7980.basic.service.organization.menu.service.impl;

import com.wenyu7980.basic.exception.code404.NotFoundException;
import com.wenyu7980.basic.service.organization.menu.entity.MenuEntity;
import com.wenyu7980.basic.service.organization.menu.entity.MenuKey;
import com.wenyu7980.basic.service.organization.menu.repository.MenuRepo;
import com.wenyu7980.basic.service.organization.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepo menuRepo;

    @Override
    public List<MenuEntity> saveAll(List<MenuEntity> entities) {
        return menuRepo.saveAll(entities);
    }

    @Override
    public List<MenuEntity> findByUserId(String userId) {
        return menuRepo.findByRoleUsersId(userId);
    }

    @Override
    public MenuEntity findById(MenuKey menuKey) {
        return menuRepo.findById(menuKey).orElseThrow(
                () -> new NotFoundException("菜单:{0},{1}不存在", menuKey.getCode(),
                        menuKey.getRoleId()));
    }

    @Override
    public MenuEntity save(MenuEntity entity) {
        return menuRepo.save(entity);
    }
}
