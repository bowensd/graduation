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
@TableName("a_base_assignment")
public class Assignment implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 状态
     */
    private String stateName;
    /**
     * 状态码，0：未下发，1：已下发，2：已确认查看
     */
    private Integer stateCode;
    /**
     * 下发时间
     */
    private Date sendTime;
    /**
     * 接收学生id
     */
    private Integer studentId;
    /**
     * 发送教师id
     */
    private Integer teacherId;
    /**
     * 主要内容和要求
     */
    private String assignmentContent;
    /**
     * 毕业设计进度安排
     */
    private String designSchedule;
    /**
     * 主要参考资料
     */
    private String reference;
    /**
     * 主要仪器设备及材料
     */
    private String device;
    /**
     * 场地及要求
     */
    private String place;
    /**
     * 指导答疑时间安排
     */
    private String answerTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getStateCode() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getAssignmentContent() {
        return assignmentContent;
    }

    public void setAssignmentContent(String assignmentContent) {
        this.assignmentContent = assignmentContent;
    }

    public String getDesignSchedule() {
        return designSchedule;
    }

    public void setDesignSchedule(String designSchedule) {
        this.designSchedule = designSchedule;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    @Override
    public String toString() {
        return "ABaseAssignment{" +
                ", id=" + id +
                ", stateName=" + stateName +
                ", stateCode=" + stateCode +
                ", sendTime=" + sendTime +
                ", studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", assignmentContent=" + assignmentContent +
                ", designSchedule=" + designSchedule +
                ", reference=" + reference +
                ", device=" + device +
                ", place=" + place +
                ", answerTime=" + answerTime +
                "}";
    }
}
