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
@TableName("a_base_guidance")
public class Guidance implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 学生ID
     */
    private Integer studentId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 指导日期
     */
    private Date guidanceDate;
    /**
     * 指导小时数
     */
    private Double guidanceHour;
    /**
     * 主要指导内容
     */
    private String guidanceContent;
    /**
     * 存在问题及改进意见
     */
    private String guidanceProblem;
    /**
     * 备注
     */
    private String remark;
    /**
     * 附件
     */
    private String appendix;
    /**
     * 记录创建时间
     */
    private Date createDate;
    /**
     * 最近更新时间
     */
    private Date updateDate;
    /**
     * 删除码，1：未删除，0：已删除
     */
    private Integer deletedNum;
    /**
     * 是否删除
     */
    private String deletedState;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getGuidanceDate() {
        return guidanceDate;
    }

    public void setGuidanceDate(Date guidanceDate) {
        this.guidanceDate = guidanceDate;
    }

    public Double getGuidanceHour() {
        return guidanceHour;
    }

    public void setGuidanceHour(Double guidanceHour) {
        this.guidanceHour = guidanceHour;
    }

    public String getGuidanceContent() {
        return guidanceContent;
    }

    public void setGuidanceContent(String guidanceContent) {
        this.guidanceContent = guidanceContent;
    }

    public String getGuidanceProblem() {
        return guidanceProblem;
    }

    public void setGuidanceProblem(String guidanceProblem) {
        this.guidanceProblem = guidanceProblem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAppendix() {
        return appendix;
    }

    public void setAppendix(String appendix) {
        this.appendix = appendix;
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

    public Integer getDeletedNum() {
        return deletedNum;
    }

    public void setDeletedNum(Integer deletedNum) {
        this.deletedNum = deletedNum;
    }

    public String getDeletedState() {
        return deletedState;
    }

    public void setDeletedState(String deletedState) {
        this.deletedState = deletedState;
    }

    @Override
    public String toString() {
        return "ABaseGuidance{" +
                ", id=" + id +
                ", studentId=" + studentId +
                ", studentName=" + studentName +
                ", guidanceDate=" + guidanceDate +
                ", guidanceHour=" + guidanceHour +
                ", guidanceContent=" + guidanceContent +
                ", guidanceProblem=" + guidanceProblem +
                ", remark=" + remark +
                ", appendix=" + appendix +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", deletedNum=" + deletedNum +
                ", deletedState=" + deletedState +
                "}";
    }
}

