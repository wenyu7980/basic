package com.wenyu7980.basic.service.organization.menu.repository;

import com.wenyu7980.basic.service.organization.menu.entity.MenuEntity;
import com.wenyu7980.basic.service.organization.menu.entity.MenuKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Repository
public interface MenuRepo extends JpaRepository<MenuEntity, MenuKey> {
    /**
     * 通过用户id查询
     * @param userId
     * @return
     */
    List<MenuEntity> findByRoleUsersId(String userId);
}
