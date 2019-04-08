package com.dky.modules.sys.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author bowen
 * @since 2019-04-07
 */
@TableName("a_base_midsupervise")
public class Midsupervise implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 中期报告ID主键
     */
   // @TableId(value = "id", type = IdType.AUTO)
    @TableId
    private Integer id;
    /**
     * 学生ID
     */
    private Integer studentId;

    /**
     * 课题ID
     */
    private Integer projectId;

    /**
     * 中期报告状态码，1：未审核，2：不合格，3：审核通过
     */
    private Integer midStateNumber;
    /**
     * 中期报告状态
     */
    private String midStateName;
    /**
     * 是否符合任务书要求进度
     */
    private String isSchedule;
    /**
     * 是否按期完成
     */
    private String isFinish;
    /**
     * 已完成的任务
     */
    private String finishedText;
    /**
     * 尚需完成的任务
     */
    private String unfinishedText;
    /**
     * 存在的问题
     */
    private String exitedProblems;
    /**
     * 拟采取的方法
     */
    private String approach;
    /**
     * 附件名
     */
    private String attachmentName;


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


    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getMidStateNumber() {
        return midStateNumber;
    }

    public void setMidStateNumber(Integer midStateNumber) {
        this.midStateNumber = midStateNumber;
    }

    public String getMidStateName() {
        return midStateName;
    }

    public void setMidStateName(String midStateName) {
        this.midStateName = midStateName;
    }

    public String getIsSchedule() {
        return isSchedule;
    }

    public void setIsSchedule(String isSchedule) {
        this.isSchedule = isSchedule;
    }

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }

    public String getFinishedText() {
        return finishedText;
    }

    public void setFinishedText(String finishedText) {
        this.finishedText = finishedText;
    }

    public String getUnfinishedText() {
        return unfinishedText;
    }

    public void setUnfinishedText(String unfinishedText) {
        this.unfinishedText = unfinishedText;
    }

    public String getExitedProblems() {
        return exitedProblems;
    }

    public void setExitedProblems(String exitedProblems) {
        this.exitedProblems = exitedProblems;
    }

    public String getApproach() {
        return approach;
    }

    public void setApproach(String approach) {
        this.approach = approach;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    @Override
    public String toString() {
        return "ABaseMidsupervise{" +
        ", id=" + id +
        ", studentId=" + studentId +
        ", projectId=" + projectId +
        ", midStateNumber=" + midStateNumber +
        ", midStateName=" + midStateName +
        ", isSchedule=" + isSchedule +
        ", isFinish=" + isFinish +
        ", finishedText=" + finishedText +
        ", unfinishedText=" + unfinishedText +
        ", exitedProblems=" + exitedProblems +
        ", approach=" + approach +
        ", attachmentName=" + attachmentName +
        "}";
    }

}
