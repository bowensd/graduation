package com.dky.modules.sys.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
*describe: token用户
*
*@author bowen
*@date 2018/5/3
*/
@TableName("a_base_user")
public class TokenUser implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 账户
     */
    private String accounts;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别，1：男，0：女
     */
    private Integer genderCode;
    /**
     * 性别
     */
    private String genderName;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 所属系部
     */
    private String department;
    /**
     * 创建时间
     */
    private Date dateCreate;
    /**
     * 删除标识符，1：已删除，0：未删除
     */
    private Integer deletedNumber;
    /**
     * 是否删除
     */
    private String deletedName;
    /**
     * 备注
     */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(Integer genderCode) {
        this.genderCode = genderCode;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Integer getDeletedNumber() {
        return deletedNumber;
    }

    public void setDeletedNumber(Integer deletedNumber) {
        this.deletedNumber = deletedNumber;
    }

    public String getDeletedName() {
        return deletedName;
    }

    public void setDeletedName(String deletedName) {
        this.deletedName = deletedName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenUser tokenUser = (TokenUser) o;
        return Objects.equals(id, tokenUser.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TokenUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accounts='" + accounts + '\'' +
                ", password='" + password + '\'' +
                ", genderCode=" + genderCode +
                ", genderName='" + genderName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", department='" + department + '\'' +
                ", dateCreate=" + dateCreate +
                ", deletedNumber=" + deletedNumber +
                ", deletedName='" + deletedName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}