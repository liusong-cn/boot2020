package com.bz.domain;

import java.io.Serializable;

/**
 * (SysRoleMenu)实体类
 *
 * @author makejava
 * @since 2020-09-16 09:12:30
 */
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = -23982728774959019L;
    /**
    * 角色id
    */
    private Long roleId;
    /**
    * 菜单id
    */
    private Long menuId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}