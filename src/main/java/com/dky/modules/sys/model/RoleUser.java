package com.dky.modules.sys.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
*describe: 角色用户
*
*@author bowen
*@date 2018/5/23 16:51
*/
@TableName("a_base_role_user")
public class RoleUser implements Serializable {

    @TableId
    private String id;
    private String userId;
    private String roleId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleUser{" +
        ", id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        "}";
    }
}
