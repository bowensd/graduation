package com.dky.modules.sys.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
*describe:菜单
*
*@author bowen
*@date 2018/5/23 11:29
*/
@TableName("a_base_menu")
public class Menu implements Serializable {

    /**
     * 主键，UUID
     */
    @TableId
    private String id;
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父级ID，顶级ID为0
     */
    private String pId;
    /**
     * 状态标识：1，启用；0，禁用
     */
    private Integer stateCode;
    /**
     * 状态标识说明：1，启用；0，禁用
     */
    private String stateName;
    /**
     * 删除标识：1，已删除；0，未删除
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pId='" + pId + '\'' +
                ", stateCode=" + stateCode +
                ", stateName='" + stateName + '\'' +
                '}';
    }
}
