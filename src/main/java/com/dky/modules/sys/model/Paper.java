package com.dky.modules.sys.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/07
 */
@TableName("a_base_paper")
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 课题ID
     */
    private String projectId;
    /**
     * 课题名称
     */
    private String projectName;
    /**
     * 论文内容
     */
    private String paperContent;
    /**
     * 参考文献
     */
    private String reference;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 最近更新时间
     */
    private Date updateDate;
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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPaperContent() {
        return paperContent;
    }

    public void setPaperContent(String paperContent) {
        this.paperContent = paperContent;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
    public String toString() {
        return "ABasePaper{" +
                ", id=" + id +
                ", projectId=" + projectId +
                ", projectName=" + projectName +
                ", paperContent=" + paperContent +
                ", reference=" + reference +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", deletedNumber=" + deletedNumber +
                ", deletedName=" + deletedName +
                ", remark=" + remark +
                "}";
    }
}

