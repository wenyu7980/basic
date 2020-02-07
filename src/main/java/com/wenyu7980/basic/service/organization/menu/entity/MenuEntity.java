package com.wenyu7980.basic.service.organization.menu.entity;

import com.wenyu7980.basic.service.organization.role.entity.RoleEntity;

import javax.persistence.*;

/**
 *
 * @author wenyu
 * @date 2020-02-07 
 */
@Table(name = "sys_menu")
@Entity
public class MenuEntity {
    @EmbeddedId
    private MenuKey key = new MenuKey();
    @MapsId("roleId")
    @ManyToOne
    private RoleEntity role;

    private MenuEntity() {
    }

    public MenuEntity(RoleEntity role, String code) {
        this.key.setCode(code);
        this.role = role;
    }

    public String getCode() {
        return this.key.getCode();
    }

    public RoleEntity getRole() {
        return role;
    }
}
