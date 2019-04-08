package com.dky.modules.sys.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
*describe: 角色菜单
*
*@author bowen
*@date 2019/4/7 16:51
*/
@TableName("a_base_role_menu")
public class RoleMenu implements Serializable {


    @TableId
    private String id;
    private String menuId;
    private String roleId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
        ", id=" + id +
        ", menuId=" + menuId +
        ", roleId=" + roleId +
        "}";
    }
}
