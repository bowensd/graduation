package com.dky.modules.sys.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
*describe: 角色
*
*@author bowen
*@date 2018/5/23 16:51
*/
@TableName("a_base_role")
public class Role implements Serializable {


    @TableId
    private String id;
    private String name;
  //  private String userId;
    private Integer deletedCode;
    private String deletedName;
    private Integer stateCode;
    private String stateName;
    private Integer sortIndex;
    private String remark;


    public Integer getDeletedCode() {
        return deletedCode;
    }

    public void setDeletedCode(Integer deletedCode) {
        this.deletedCode = deletedCode;
    }

    public String getDeletedName() {
        return deletedName;
    }

    public void setDeletedName(String deletedName) {
        this.deletedName = deletedName;
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

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

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

//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
             //   ", userId='" + userId + '\'' +
                ", deletedCode=" + deletedCode +
                ", deletedName='" + deletedName + '\'' +
                ", stateCode=" + stateCode +
                ", stateName='" + stateName + '\'' +
                ", sortIndex=" + sortIndex +
                ", remark='" + remark + '\'' +
                '}';
    }
}
